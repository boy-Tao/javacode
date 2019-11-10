/*
//水仙花数
public class Test {

    public static  void main(String[] args) {
        int n = 999999;
        waterFlower(n);

    }

    public static void waterFlower(int n) {
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int count = 0;
            int temp = i;
            while (temp != 0) {
                count++;
                temp = temp / 10;
            }
            temp = i;
            while (temp != 0) {
                sum += Math.pow(temp % 10, count);
                temp = temp / 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }

}*/

/*

//输入密码，三次错误推出。
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        fun1();
    }

    public static void fun1() {
        Scanner sc = new Scanner(System.in);
        int i = 3;
        while(i != 0) {
            System.out.println("请输入你的密码：");
            String password = sc.nextLine();
            if("ig666".equals(password)) {
                System.out.println("密码正确");
                break;
            }
            else {
                System.out.println("密码错误");
                i--;
            }
        }
    }

}
*/


public class Test {
    public static

}