import java.util.Arrays;

class MyArrayList {
    //属性
    private int[] elem;
    private int usedSize;
    private final int CAPACITY = 5;

    public MyArrayList() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    //方法
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }

    //判断是否越界
    private boolean isFull() {
        /*if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (isFull()) {
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }

        if(pos < 0 || pos > this.usedSize) {
            System.out.println("该位置不合法");
            return;
        }
        //挪数据
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(i == pos) {
                this.elem[i] = value;
            }
        }
        display();
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("找不到要删除的数字。");
        }
        for (int i = index; i < this.usedSize; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        display();
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
        System.out.println("清空");
    }
}

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,12);
        myArrayList.add(1,3);
        myArrayList.add(2,6);
        myArrayList.add(2,23);
        myArrayList.add(2,5);
        myArrayList.add(2,9);
        myArrayList.display();
        System.out.println();
        System.out.println(myArrayList.search(12));
        myArrayList.setPos(0,66);
        System.out.println();
        myArrayList.remove(5);
        System.out.println();
        myArrayList.clear();
    }
}



