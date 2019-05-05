package com.solarexsoft.learningretrofit.testgson;

import com.google.gson.Gson;

/**
 * Created by houruhou on 2019/5/5.
 * Desc:
 */
public class TestGson {
    public static void main(String[] args) {
        ChangePasswordModel model = new ChangePasswordModel();
        model.setAccountId("solarex");
        model.setPassword("123456");
        Gson gson = new Gson();
        String str = gson.toJson(model);
        System.out.println(str);
    }
}
