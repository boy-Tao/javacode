class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MySingleList {
    //public ListNode head = null;

    public ListNode head;

    public MySingleList() {
        this.head = null;
    }

    //头添加
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾添加
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印链表
    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //任意位置插入,第一个数据节点为0号下标
    private ListNode searchIndex(int index) {
        ListNode prev = this.head;
        int count = 0;
        while (count < index - 1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }

    public void addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        if (index < 0 || index > getLength()) {
            System.out.println("插入下标不合法");
        }
        if (index == 0) {
            addFirst(data);
        }else {
            ListNode prev = searchIndex(index);
            node.next = prev.next;
            prev.next = node;
        }
    }

    //链表长度
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //判断是否存在关键字key
    public boolean contains1(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key) {
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
        ListNode prev = searchPrev(key);
        if (prev == null) {
            System.out.println("要删除的节点不存在");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有的key值
    public void removeAllKey (int key) {
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //反转单链表
    public ListNode reverseList() {
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //打印反转单链表
    public void display2(ListNode newHead) {
        //ListNode newHead = reverseList();
        if (newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找中间节点
    public int middleNode() {
        int len = getLength() / 2;
        int count = 0;
        ListNode cur = this.head;
        while (count < len) {
            cur = cur.next;
            count++;
        }
        return cur.data;
    }

    public int middleNode2() {
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    //输出该链表中倒数第k个结点
    public ListNode findKthToTail(int k) {
        if(k <= 0 || k > getLength()) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("输入有问题");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}

public class SingleList {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(6);
        mySingleList.addLast(5);
        mySingleList.addIndex(2,9);
        mySingleList.addLast(8);
        mySingleList.addLast(9);
        mySingleList.display();
        //mySingleList.removeKey(9);
        mySingleList.removeAllKey(9);
        mySingleList.display();
        mySingleList.addIndex(0,21);
        mySingleList.display();
        /*System.out.println(mySingleList.getLength());
        System.out.println(mySingleList.contains1(9));*/
        //mySingleList.reverseList();
        /*ListNode node = mySingleList.reverseList();
        mySingleList.display2(node);*/
        //System.out.println(mySingleList.middleNode());
        /*ListNode node = mySingleList.findKthToTail(5);
        System.out.println(node.data);*/
    }
}