package com.solarexsoft.learningretrofit;

import okhttp3.*;
import okio.*;

import java.io.IOException;

/**
 * Created by houruhou on 2018/9/18.
 * Desc:
 */
public class ProgressMain {
    interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }
    private static class ProgressResponseBody extends ResponseBody {
        private final ResponseBody responseBody;
        private final ProgressListener progressListener;
        private BufferedSource bufferedSource;

        public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return this.responseBody.contentLength();
        }

        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(this.responseBody.source()));
            }
            return bufferedSource;
        }

        private Source source(BufferedSource source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0l;
                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                    progressListener.update(bytesRead, responseBody.contentLength(), bytesRead == -1);
                    return bytesRead;
                }
            };
        }
    }

    public static void run() throws Exception {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        final ProgressListener progressListener = new ProgressListener() {
            boolean firstUpdate = true;

            @Override
            public void update(long bytesRead, long contentLength, boolean done) {
                if (done) {
                    System.out.println("done");
                } else {
                    if (firstUpdate) {
                        firstUpdate = false;
                        if (contentLength == -1) {
                            System.out.println("content-length: unknown");
                        } else {
                            System.out.format("content-length: %d\n", contentLength);
                        }
                    }

                    System.out.println(bytesRead);

                    if (contentLength != -1) {
                        System.out.printf("%d%% done\n", 100*bytesRead/contentLength);
                    }
                }
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originResponse = chain.proceed(chain.request());
                        return originResponse.newBuilder()
                                .body(new ProgressResponseBody(originResponse.body(), progressListener))
                                .build();
                    }
                })
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) throws Exception{
        run();
    }
}
