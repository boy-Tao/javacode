package com.bin;/*
 *@author：Tao
 *@date：2019/11/18
 */

public class TestDemo1 {
    public static void main(String[] args) {
        Animal animal = new Bird("圆圆");
        animal.eat("谷子");
        // (Bird) 表示强制类型转换
        Bird bird = (Bird)animal;
        bird.fly();
        // 执行结果：圆圆正在飞
    }
}
