package com.ele.Test;

import cn.hutool.crypto.SecureUtil;

public class Test {
    public static void main(String[] args) {
        String a = "张三";
        String b = "123";
        b = SecureUtil.md5(b + a);
        System.out.println(b);
    }
}
