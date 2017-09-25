package com.solarexsoft.learningretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by houruhou on 25/09/2017.
 */
public interface Github {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<User>> contributors(@Path("owner") String owner, @Path("repo") String repo);
}
