package com.bin;
/*import java.util.Date;
import java.util.Arrays;*/
import java.util.*;
//import java.sql.*;
import static java.lang.System.*;

/*
 *@author：Tao
 *@date：2019/11/17
 */

/**
 * java.util ->工具类
 *java.lang -> 包底下的所有东西  全部不需要自己导入
 * 编译器会自动导入java.lang
 */
class Person {
    int age;
}
public class Test {

    public static void main(String[] args) {
        out.println("JAVA20");
    }


    public static void main1(String[] args) {
        String str = "hello";
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
        Date date = new Date();
        //java.util.Date date = new java.util.Date();
        System.out.println(date.getTime());
        //格林威治时间-》1970.1.1-》毫秒数
        //System.out.println("Java20!");
    }
}

