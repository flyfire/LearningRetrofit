package com.solarexsoft.learningretrofit.testgson;

/**
 * Created by houruhou on 2019/8/5.
 * Desc:
 */
public class Account {
    long accountid;
    String accountname;
    String photourl;

    public Account(long accountid, String accountname, String photourl) {
        this.accountid = accountid;
        this.accountname = accountname;
        this.photourl = photourl;
    }
}
