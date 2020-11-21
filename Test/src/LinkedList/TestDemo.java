package LinkedList;

public class TestDemo {
    //链表相交
    public Node getIntersectionNode(Node headA,Node headB){
        if(headA==null||headB==null){
            return null;
        }
        int lenA=0;
        int lenB=0;

        Node pl=headA;
        Node ps=headB;

        while(ps!=null){
            lenB++;
            ps=ps.next;
        }
        while(pl!=null){
            lenA++;
            pl=pl.next;
        }
        pl=headA;
        ps=headB;
        int len=lenA-lenB;
        if(len<0){
            ps=headA;
            pl=headB;
            len=lenB-lenA;
        }
        while(len>0){
            len--;
            pl=pl.next;
        }
        while(pl!=null&&ps!=null&&pl!=ps){
            pl=pl.next;
            ps=ps.next;
        }
        if(pl==ps&&pl!=null){
            return pl;
        }
        return null;
    }




    //合并两个有序地链表
    public Node mergeTwoLists(Node headA,Node headB){
        Node newHead=new Node(-1);
        Node tmp=newHead;

        //当前两个链表都有数据
        while(headA!=null&&headB!=null){
            if(headA.val<headB.val){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            }else{
                tmp.next=headB;
                tmp=tmp.next;
                headB=headB.next;
            }
        }

        if(headA!=null){
            tmp.next=headA;
        }
        if(headB!=null){
            tmp.next=headB;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(12);

        myLinkedList.addLast(12);
        myLinkedList.addLast(12);
        myLinkedList.addLast(34);
        myLinkedList.addLast(55);
        myLinkedList.addLast(78);

        myLinkedList.addLast(78);
        System.out.println(myLinkedList.deleteDuplication());

        myLinkedList.display();//12 12 34 78 12 55 12 12

    }
}
