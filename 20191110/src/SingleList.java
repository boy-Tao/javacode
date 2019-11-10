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

    //打印头改变后的新链表
    public void display2(ListNode newHead) {
        //ListNode newHead = partition(x);
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

    //以x为基准分割链表
    public ListNode partition(int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = cur;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            }else {
                if (afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                }else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        if (afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }

    //删除有序链表的所有重复节点
    public ListNode deleteDuplication(){
        if (this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            //重复的节点
            if(cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //如果最后一个节点也是重复的，需将tmp置为null；
        tmp.next = null;
        return newHead.next;
    }

    //判断链表是否为回文结构
    public boolean chkPalindrome() {
        //1、找到单链表的中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转单链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、slow往前    head往后走
        while(this.head != slow) {
            if (head.data != slow.data) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    // 给定一个链表，判断链表中是否有环。
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //返回链表入环的第一个节点
    public ListNode detectCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class SingleList {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(6);
        mySingleList.addFirst(6);
        mySingleList.addFirst(5);
        mySingleList.addFirst(3);
        mySingleList.addFirst(2);
        mySingleList.addFirst(2);
        mySingleList.display();
        /*ListNode newHead = mySingleList.partition(5);
        mySingleList.display2(newHead);*/
        ListNode newHead = mySingleList.deleteDuplication();
        mySingleList.display2(newHead);
    }
}
