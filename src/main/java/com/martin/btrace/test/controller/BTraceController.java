package com.martin.btrace.test.controller;

import com.martin.btrace.test.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BTraceController {

    @RequestMapping("/args")
    public String args(String arg1, String arg2) {
        return arg1 + " " + arg2;
    }

    @RequestMapping("/constructor")
    public User constructor() {
        return new User("admin", "123456");
    }

    @RequestMapping("/referenceArgs")
    public String referenceArgs(User user) {
        return "success";
    }

    @RequestMapping("/throwable")
    public void throwable() {
        try {
            int a = 1 / 0;
        } catch (Throwable throwable) {
            //nothing to do.
        }
    }

    @RequestMapping("/line")
    public String line() {
        String ret = "Hello World"; //line = 37
        return ret;
    }
}
