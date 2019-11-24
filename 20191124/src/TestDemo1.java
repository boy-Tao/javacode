import java.util.Arrays;

class Students implements Comparable<Students> {
    public String name;
    public int age;
    public double score;

    public Students(String name,int age,double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        return this.name.compareTo(o.name);
        //return (int)(this.score - this.score);
        //return this.age - o.age;
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        Students[] students = new Students[3];
        students[0] = new Students("caocao",15,85.0);
        students[1] = new Students("zhangfei",26,78.0);
        students[2] = new Students("theshy",20,99.0);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

