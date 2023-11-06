package com.codewithsj.views;

import com.codewithsj.utils.StringUtil;

import static com.codewithsj.utils.AppOutput.println;

public class AdminPage {
    public void welcomeMsg() {
        println(StringUtil.ADMIN_WELCOME);
    }

    public void adminMenu() {
        println(StringUtil.ADMIN_CHOICE);
    }
}
