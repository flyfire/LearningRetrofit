package com.solarexsoft.learningretrofit.testgson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by houruhou on 2019/9/18.
 * Desc:
 */
public class TestJsonObject {

    public static void main(String[] args) {
        String json = "{\"1000000100580511\": \"Agency\" ,\"1000000100580512\": \"Expert\" ,\"1000000100580513\": \"Talent\" }";
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("1000000100580511"));
        System.out.println(String.valueOf(jsonObject.get("aaa")));
        System.out.println(jsonObject.get("bbb"));
    }
}
