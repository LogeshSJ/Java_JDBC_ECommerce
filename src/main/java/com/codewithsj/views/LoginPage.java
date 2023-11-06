package com.codewithsj.views;

import com.codewithsj.utils.StringUtil;

import static com.codewithsj.utils.AppOutput.println;

public class LoginPage {
    public void printInvalidCredentials() {
        println(StringUtil.INVALID_CREDENTIALS);
    }

    public void loginSuccess() {
        println(StringUtil.LOGIN_SUCCESS);
    }
}
