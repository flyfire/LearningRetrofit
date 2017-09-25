package com.solarexsoft.learningretrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * Created by houruhou on 25/09/2017.
 */
public class Hello {
    public static void main(String[] args) {
        Github github = new Retrofit.Builder().baseUrl("https://api.github.com")
    //            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Github.class);
        Call<List<User>> call = github.contributors("square", "retrofit");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                if (users != null) {
                    for (User user : users) {
                        System.out.println(user);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
