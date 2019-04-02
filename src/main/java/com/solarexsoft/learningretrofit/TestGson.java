package com.solarexsoft.learningretrofit;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by houruhou on 2018/8/28.
 */
public class TestGson {
    static class Test {
        /**
         * createDateTime : 10000
         * name : solarex
         */

        private int createTime;
        private String name;

//        {"createDateTime":10000,"name":"solarex"}


        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class ExInfo {

        /**
         * unlockPageUrl : https://www.baidu.com
         * Duration : 15
         */

        private String unlockPageUrl;
        private int Duration;

        public String getUnlockPageUrl() {
            return unlockPageUrl;
        }

        public void setUnlockPageUrl(String unlockPageUrl) {
            this.unlockPageUrl = unlockPageUrl;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int Duration) {
            this.Duration = Duration;
        }
    }

    public static void main(String[] args) {

        String str = "{\"createDateTime\":{\"a\":1111},\"name\":\"solarex\"}";
        Gson gson = new Gson();
        Test tmp = gson.fromJson(str, Test.class);
        System.out.println(tmp);
        str = "{\"Duration\":15}";
        ExInfo exInfo = gson.fromJson(str, ExInfo.class);
        System.out.println(exInfo);
        /*
        String emptyStr = "{}";
        String empty = gson.fromJson(emptyStr, String.class);
        System.out.println(empty);
        */
        String abcd = "abc";
        System.out.println(gson.toJson(abcd));
        /*
        boolean a = gson.fromJson(String.valueOf(true), Boolean.class);
        System.out.println(a);
        */
        try {
            Boolean a = true;
            Boolean aBoolean = gson.getAdapter(Boolean.class).fromJson(a.toString());
            System.out.println(aBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sleep = "{\n" +
                "        \"timestamp\": 1553068800000,\n" +
                "        \"startTime\": 1553032800000,\n" +
                "        \"endTime\": 1553061600000,\n" +
                "        \"timeAsleep\": 28800\n" +
                "    }";
        SleepStatisticsModel model = gson.fromJson(sleep, SleepStatisticsModel.class);
        System.out.println(model);

        System.out.println(gson.toJson(null));
    }
}
