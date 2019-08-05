package com.solarexsoft.learningretrofit.testgson;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by houruhou on 2019/8/5.
 * Desc:
 */
public class TestBase64 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Account account = new Account(100000l, "solarex", "http://www.baidu.com");
        String str = new Gson().toJson(account);
        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString(str.getBytes("utf-8"));
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        String ds = new String(decode, "utf-8");
        System.out.println(ds);
    }
}
