class Listnode {
    public int data;
    public Listnode next;
    public Listnode prev;
    public Listnode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class MyDoubleList {
    public Listnode head;
    public Listnode last;
    public MyDoubleList() {
        this.head = null;
        this.last = null;
    }

    //头添加
    public void addFirst(int data) {
        Listnode node = new Listnode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        }
        this.head.prev = node;
        node.next = this.head;
        this.head = node;
    }

    //尾添加
    public void addLast(int data) {
        Listnode node = new Listnode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        //中间插入
        Listnode node = new Listnode(data);
        Listnode cur = this.head;
        if (index < 0 || index > size()) {
            return false;
        }
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        Listnode Next = cur;
        Listnode Prev = cur.prev;
        Prev.next = node;
        node.prev = Prev;
        node.next = Next;
        Next.prev = node;
        return true;
    }

    //链表长度
    public int size() {
        Listnode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表
    public void display() {
        Listnode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //判断关键字key是否在链表中
    public boolean contains(int key) {
        Listnode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Listnode cur = this.head;
        while (cur != null) {
            if (cur.data == key && cur.prev == null) {
                this.head = cur.next;
                this.head.prev = null;
                return;
            }
            if (cur.data == key && cur.next == null) {
                this.last = cur.prev;
                this.last.next = null;
                return;
            }
            if (cur.data == key) {
                Listnode Prev = cur.prev;
                Listnode Next = cur.next;
                Prev.next = Next;
                Next.prev = Prev;
            }
            cur = cur.next;
        }
    }

    //删除所有关键字为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        Listnode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                if (cur.prev == null) {
                    this.head = cur.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //清空链表
    public void clear() {
        while (this.head != null) {
            Listnode cur = this.head.next;
            this.head = null;
            this.head = cur;
        }
        this.last = null;
    }
}

public class DoubleList {
    public static void main(String[] args) {
        MyDoubleList myDoubleList = new MyDoubleList();
        myDoubleList.addLast(2);
        myDoubleList.addLast(3);
        myDoubleList.addLast(4);
        myDoubleList.addLast(5);
        myDoubleList.addIndex(0,1);
        myDoubleList.addIndex(2,4);
        myDoubleList.addFirst(4);
        myDoubleList.display();
        myDoubleList.remove(5);
        myDoubleList.display();
        myDoubleList.removeAllKey(4);
        myDoubleList.display();
    }
}
