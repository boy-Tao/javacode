
//14. 完成猜数字游戏。

import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int toGuess = random.nextInt(100);
        while (true) {
            System.out.println("请输入要输入的数字: (1-100)");
            int num = sc.nextInt();
            if (num < toGuess) {
                System.out.println("低了");
            } else if (num > toGuess) {
                System.out.println("高了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
}

/*
//13. 输出一个整数的每一位。

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fun(num);
    }

    public static void fun(int num) {
        if(num > 9) {
            fun(num / 10);
        }
        System.out.println(num % 10);
    }
}


//9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)

public class Test {

    public static void main(String[] args) {
        for (int i = 100; i <= 999; ++i)
        {
            int  a = 0;
            int  b = 0;
            int  c= 0;
            a = i % 10;
            b = (i - a) / 10 % 10;
            c =i / 100;
            int sum = pow(a) + pow(b) + pow(c);
            if (i==sum)
                System.out.println("i = " + i);
        }
    }

    public static int pow(int a) {
        return a * a * a;
    }

}


//8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。

public class Test {
    public static void main(String[] args) {
        int n = 100;
        NumOfNine(n);
        System.out.println("num = " + NumOfNine(n));
    }

    public static int NumOfNine(int n) {
        int num = 0;
        int i = 1;
        while(i <= n) {
            int remain = i % 10;
            if(i / 10 == 9 || (remain % 9 == 0 && remain != 0)) {
                num++;
            }
            i++;
        }
        num++;
        return num;
    }

}


//7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。

public class Test {
    public static void main(String[] args) {
        double i = 1.0;
        double sum = 0.0;
        while (i <= 100) {
            if(i % 2 == 1) {
                sum = sum + 1.0/i;
            }
            else {
                sum = sum - 1.0/i;
            }
            i++;
        }
        System.out.println("sum = " + sum);
    }
}


//6. 求两个正整数的最大公约数。

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("最大公约数 = " + GCD(a, b));
        System.out.println("最小公倍数 = " + LCM(a, b));
    }

    public static int GCD(int a, int b) {
        int gcd = 1;
        int temp = a < b ? a : b;
        while (temp > 0) {
            if (a % temp == 0 && b % temp == 0) {
                gcd = temp;
                break;
            }
            temp--;
        }
        return gcd;
    }

    public static int LCM(int a, int b) {
        int lcm = 1;
        int temp = a > b ? a : b;
        while (temp >= a) {
            if (temp % a == 0 && temp % b == 0) {
                lcm = temp;
                break;
            }
            temp++;
        }
        return lcm;
    }

}

//最大公约数

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(GCD(a,b));
    }

    public static int GCD(int a,int b){
        int temp = b;
        while(a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return temp;
    }

}


//5. 输出乘法口诀表。

public class Test {
    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            System.out.println("");
            for (int j = 1; j <= i; j++) {
			    System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
        }
    }
}


//4. 输出 1000 - 2000 之间所有的闰年。

public class Test {
    public static void main(String[] args) {

        int year = 1000;
        while(year <= 2000) {
            if(Judge(year))
                System.out.println(year);
            year++;
        }
    }

    public static boolean Judge(int year) {
        if((year % 100 != 0 && year %4 == 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

}


//3. 打印 1 - 100 之间所有的素数。

public class Test {
    public static void main(String[] args) {

        int n = 1;
        while(n <= 100) {
            if(Judge(n))
                System.out.println(n);
            n++;
        }
    }

    public static boolean Judge(int n) {
        if(n == 1) {
            return false;
        }
        else {
            for(int i = 2; i < n; i++) {
                if(n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}


//2. 判定一个数字是否是素数。

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        boolean isPrime = true;
        if(num < 0) {
            System.out.println("输入错误");
        }

        else if(num == 0 || num == 1 ) {
            isPrime = false;
        }

        else {
            int i = 2;
            while(i < num) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
        }

        if(isPrime) {
            System.out.println("是素数");
        }
        else {
            System.out.println("不是素数");
        }

    }
}


//1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)。

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        if(age <= 0) {
            System.out.println("输入错误");
        }
        else if(age <= 18) {
            System.out.println("少年");
        }
        else if(age <= 28) {
            System.out.println("青年");
        }
        else if(age <= 55) {
            System.out.println("中年");
        }
        else if(age <= 56) {
            System.out.println("老年");
        }
        else {
            System.out.println("老年");
        }
    }
}
*/
