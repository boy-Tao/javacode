class SingleList {
    public ListNode head;
    public SingleList() {
        this.head = null;
    }

    //头添加
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //打印单链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //尾添加
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        }else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //求单链表长度
    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    private ListNode searchIndex (int index) {
        ListNode prev = this.head;
        int count = 0;
        while (count < index-1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }
    public void addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        if (index < 0 || index > getLength()) {
            System.out.println("插入不合法");
            return;
        }
        if (index == 0) {
            addFirst(data);
        }else {
            ListNode prev = searchIndex(index);
            node.next = prev.next;
            prev.next = node;
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean  contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现的值为key的节点
    private ListNode searchKey(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void removeKey(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchKey(key);
        if (prev == null) {
            System.out.println("要删除的节点不存在");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
        return;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        ListNode del = cur.next;
        while (del != null) {
            if (del.data == key) {
                del = del.next;
                cur.next = del;
            }else {
                del = del.next;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //清空链表
    public void clear() {
        //this.head = null;
        ListNode cur = this.head;
        while (this.head.next != null) {
            this.head.next = this.head.next.next;
        }
        this.head = null;
        display();
        System.out.println("清空");
    }
}


class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MySingleList {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(6);
        singleList.addFirst(5);
        singleList.addFirst(4);
        singleList.addLast(7);
        singleList.addLast(8);
        singleList.addIndex(0,3);
        singleList.addFirst(2);
        singleList.display();
        //singleList.removeKey(3);
        singleList.addFirst(2);
        singleList.display();
        singleList.removeAllKey(2);
        singleList.display();
        //System.out.println(singleList.contains(6));
        //singleList.clear();
        //System.out.println(singleList.getLength());
    }
}



