import java.util.Scanner;

class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum2() {
        return num2;
    }

    public int add() {
        return this.num1 + this.num2;
    }

    public int sub() {
        return this.num1 - this.num2;
    }

    public int mul() {
        return this.num1 * this.num2;
    }

    public int div() {
        return this.num1 / this.num2;
    }
}

class MyValue {
    public int a;
    public int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {

        return b;
    }

    public void swap() {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a=" + a + "  b=" + b);
    }
}

class Person {
    public int age;
    public String name;
    public Person() {
        System.out.println("the shy666");
    }
    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class HomeWork {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person(19,"shy");
        System.out.println(person1.toString());
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("a=" + a + "  b=" + b);
        MyValue myValue = new MyValue();
        myValue.setA(a);
        myValue.setB(b);
        myValue.swap();
    }

    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }
}
