import java.util.List;

//节点
class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MySingleList {

    public ListNode head;

    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null) {
            this.head = node;
        }else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印链表
    public void display() {
        ListNode cur = this.head;
        if(cur == null) {
            return;
        }
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int count = 0;
        while(count < index-1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }
    //插入到index位置
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index < 0 || index > getLength()) {
            return false;
        }
        //头插法
        ListNode node = new ListNode(data);
        if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        node.next = prev.next;
        prev.next = node;
        return false;
    }

    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //1、删除的节点如果是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            display();
            return;
        }
        //2、找到删除的节点的前驱  如果找不到  返回null
        ListNode prev = searchPrev(key);
        if(prev == null) {
            System.out.println("没有你要删除的节点");
            return;
        }
        ListNode del = prev.next;
        //3、进行删除
        prev.next = del.next;
        display();
    }

    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null) {
            if(prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.data == key) {
            this.head = this.head.next;
        }
        display();
    }

    public void clear() {
        this.head = null;
    }

}

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addLast(5);
        mySingleList.addLast(7);
        mySingleList.addFirst(9);
        mySingleList.addFirst(6);
        mySingleList.addFirst(6);
        mySingleList.addFirst(6);
        mySingleList.addFirst(6);//6 6 6 6 9 3 2 5 7
        //mySingleList.display();
        /*mySingleList.addIndex(0,21);
        mySingleList.display();
        System.out.println(mySingleList.getLength());
        System.out.println(mySingleList.contains(21));*/
        //mySingleList.remove(6);
        mySingleList.removeAllKey(6);
        mySingleList.remove(9);
    }
}
