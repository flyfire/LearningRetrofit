package com.solarexsoft.learningretrofit;

import com.google.gson.Gson;

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
        String str = "{\"createDateTime\":10000,\"name\":\"solarex\"}";
        Gson gson = new Gson();
        Test tmp = gson.fromJson(str, Test.class);
        System.out.println(tmp);
        str = "{\"Duration\":15}";
        ExInfo exInfo = gson.fromJson(str, ExInfo.class);
        System.out.println(exInfo);
    }
}
