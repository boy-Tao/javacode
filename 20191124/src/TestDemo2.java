class Money implements Cloneable{
    public double money = 12.5;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public String name;
    public Money m;
    public Person(String name){
        this.name = name;
        this.m = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        Person per = (Person) super.clone();
        per.m = (Money)this.m.clone();
        return per;
    }
}

public class TestDemo2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("caocao");
        Person person2 = (Person)person.clone();
        person2.name = "zhangfei";
        System.out.println(person.name);
        System.out.println(person2.name);
        System.out.println("========================");
        person2.m.money = 18.6;
        System.out.println(person.m.money);
        System.out.println(person2.m.money);
    }
}
