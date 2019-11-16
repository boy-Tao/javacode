
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
        if(this.head == null) {
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
        //0、判断是否是第一次插入
        if(this.head == null) {
            this.head = node;
        }else {
            //1、找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、进行插入
            cur.next = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    private ListNode searchIndex(int index) {
        //prev-->index-1;
        ListNode prev = this.head;
        int count = 0;
        while (count < index-1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }
    public boolean addIndex(int index,int data){
        //下标不合法
        if(index < 0 || index > getLength()) {
            return false;
        }
        //头插法
        if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return false;
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

    //打印单链表数据
    public void display(){
        if(this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains1(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public ListNode contains2(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    public void remove(int key){
        //1、删除的节点如果是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
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
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if(cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //清空链表
    public void clear(){
        //this.head = null;
        while (this.head.next != null) {
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }

    //反转单链表
    public ListNode reverseList() {
        ListNode cur = this.head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //打印新的单链表
    public void display2(ListNode newHead){
        if(newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //求链表的中间节点
    public ListNode middleNode() {
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //查找链表的倒数第k个节点
    public ListNode findKthToTail(int k) {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有要查找的节点！");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //以x为基准分割链表
    public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除链表所有重复节点
    public ListNode deleteDuplication() {
        if (this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
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
        tmp.next = null;
        return newHead.next;
    }

    //删除重复节点，保留一个重复节点
    public void deleteDulp2(){
        if(this.head == null || this.head.next == null){
            return;
        }
        ListNode cur = this.head;
        while(cur != null){
            ListNode prev = cur;
            while(prev.next != null){
                if(cur.data == prev.next.data){
                    prev.next = prev.next.next;
                }else {
                    prev = prev.next;
                }
            }
            cur = cur.next;
        }
    }

    //判断链表是否为回文结构
    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        }
        if (this.head.next == null) {
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (slow != this.head) {
            if (slow.data != this.head.data) {
                return false;
            }
            if (this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //创建一个有环的链表
    public void creatLoop() {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    //链表是否有环
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
        if (fast == null || fast.next == null)  {
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
    //合并有序单链表
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        if (headA == null && headB ==null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA == null) {
            tmp.next = headB;
        }
        if (headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }

    //找出两个链表的公共节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        ListNode pL = headA;
        ListNode pS = headB;
        int lenA = 0;
        int lenB = 0;
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA - lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        while (len > 0) {
            pL = pL.next;
            len--;
        }
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }

    //有公共节点的链表
    public static void creatCut(ListNode headA, ListNode headB) {
        headA.next = headB.next.next;
        return;
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(81);
        mySingleList.addLast(78);
        mySingleList.addLast(85);
        mySingleList.addLast(67);
        mySingleList.addLast(85);
        mySingleList.addLast(40);
        mySingleList.addLast(85);
        mySingleList.addLast(82);
        mySingleList.addLast(90);
        mySingleList.addLast(78);
        mySingleList.display();
        /*MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(2);
        mySingleList1.addLast(6);
        mySingleList1.addLast(8);
        mySingleList1.addLast(9);
        mySingleList1.display();
        creatCut(mySingleList.head,mySingleList1.head);
        ListNode node = getIntersectionNode(mySingleList.head,mySingleList1.head);
        System.out.println(node.data);*/
        /*ListNode newHead = mergeTwoLists(mySingleList.head, mySingleList1.head);
        mySingleList.display2(newHead);*/
        /*ListNode node = mySingleList.middleNode();
        System.out.println(node.data);*/
        /*ListNode newHead = mySingleList.partition(5);
        mySingleList.display2(newHead);*/
        /*ListNode newHead = mySingleList.reverseList();
        mySingleList.display2(newHead);*/
        /*ListNode node = mySingleList.findKthToTail(6);
        System.out.println(node.data);*/
        /*ListNode newHead = mySingleList.deleteDuplication();
        mySingleList.display2(newHead);*/
        //System.out.println(mySingleList.chkPalindrome());
        /*mySingleList.creatLoop();
        System.out.println(mySingleList.hasCycle());
        ListNode node = mySingleList.detectCycle();
        System.out.println(node.data);*/
        mySingleList.deleteDulp2();
        mySingleList.display();
    }
}
