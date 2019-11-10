
class Person {
    private String name;  //null 封装
    private int age;  //0
    public static int count = 100;    //静态数据成员
    public final int SIZE = 88;       //实例常量
    public static final int SIZE2 = 99;   //静态常量

    //静态代码块-->初始化静态的数据成员
    static {
        count = 8888888;
        System.out.println("静态代码块");
    }

    //实例代码块-->实例化实例数据成员
    {
        this.age = 10000;
        this.name = "哪吒";
        count = 9999;
        System.out.println("实例代码块");
    }

    //构造方法
    public Person() {
        //this("王母娘娘");
        //this("sunwukong");
        System.out.println("Person()");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Person(String)");
    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int)");
    }

    public void setName(String myName) {
        name = myName;
    }   //  "alt+insert"键,快捷生成

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        //System.out.println(count);
        System.out.println("吃饭");
    }

    public void sleep() {
        this.eat();
        System.out.println("睡觉");
    }

    public void show() {
        System.out.println("name:" + name + " age:" + age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void fun1 (Person person) {
        System.out.println("name:" + person.name);
        System.out.println("static fun1()");
    }
}

/*public class Test {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.show();
        person1.eat();
        person1.fun1(person1);
        *//*System.out.println(person1.name);
        System.out.println(person1.age);
        System.out.println(Person.count);
        Person.fun1();*//*
        *//*Person person2 = new Person();
        Person person3 = new Person();*//*
    }
}*/

public class Test {

    /*public static void func(Person person) {
        System.out.println(person.getName());
        person.sleep();
    }*/

    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println("===========");
        Person person2 = new Person();
        System.out.println("===========");
        Person person3 = new Person();
    }

    public static void main3(String[] args) {
        Person person1 = new Person();
        System.out.println(person1);
        /*System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.count);*/
    }


    public static void main2(String[] ars) {
        Person person1 = new Person();
        System.out.println("=======================");
        Person person2 = new Person("caocao");
        System.out.println("=======================");
        Person person3 = new Person("caocao",99);
    }

    public static void main1(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setAge(88);
        person1.setName("caocao");
        System.out.println(person1.getAge());
        System.out.println(person1.getName());
        person2.setAge(98);
        person2.setName("zhangfei");
        System.out.println(person2.getAge());
        System.out.println(person2.getName());
    }
}