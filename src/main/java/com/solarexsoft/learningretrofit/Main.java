package com.solarexsoft.learningretrofit;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by houruhou on 2018/5/21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
        OkHttpClient client = new OkHttpClient.Builder().build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());

        ArrayList<String> list = new ArrayList<>();
        list.add("solarex");
        list.add("flyfire");
        System.out.println(new Gson().toJson(list));

    }
}
