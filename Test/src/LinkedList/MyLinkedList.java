package LinkedList;

public class MyLinkedList {
    private Node head;

    //1.头插
    public void addFirst(int key){
        Node node=new Node(key);
        node.next=head;
        head=node;

    }

    //2.尾插
    public void addLast(int key){
        Node node=new Node(key);
        if(head==null){
            head=node;
        }else{
            //找到它的尾巴,要找到链表的最后一个结点
            Node cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            //cur.next==null,说明此时cur是最后一个节点
            cur.next=node;

        }
    }

    //3.进行打印
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    //任意位置进行插入
    public void addIndex(int index,int key){
        if(index<0||index>getLength()){
            System.out.println("下标不合法");
            return;
        }
        if(index==0){
            addFirst(key);
        }
        if(index==getLength()){
            addLast(key);
        }
        //对于其他的任意情况则是要找到插入位置的前一个位置的结点
        //Index-
        Node cur=searchPrev(index-1);
        Node node=new Node(key);
        //进行结点的绑定的时候，一定要先绑后边
        node.next=cur.next;
        cur.next=node;

    }
    public Node searchPrev(int index){
        int count=0;
        Node cur=this.head;
        while(count<index){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    public int getLength(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    //删除第一次出现的结点值=12的结点
    public void remove(int key){
        if(head==null){
            return ;
        }
        if(head.val==key){
            this.head=head.next;
            return;
        }
        //先要找到12这个节点，找到了返回节点，没有找到，则返回null
        Node cur=searchPrevIndex(key);
        //存在两种情况：
        if(cur==null){
            System.out.println("没有找到你要删除的节点");
        }else{
            cur.next=cur.next.next;
        }

    }
    public Node searchPrevIndex(int key){
        Node cur=this.head;
        while(cur.next!=null){
            if(cur.next.val==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }


    //查找关键字key是否包含在链表中
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    //删除所有结点的值都为key的
    public void removeAllKey(int key){
        //肯定会存在连续相同的好几个值连在一块要进行删除,但是还是要进行一个一个的删除相同的key的结点
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        //此时如果还存在没有删除的结点key，则一定在头节点
        if(this.head.val==key){
            this.head=this.head.next;
        }
    }

    //链表的反转
    public Node reverseList(){
        //要求只遍历一次  返回反转后头节点
        Node newHead=null;
        Node prev=null;//代表当前要反转的节点的前驱
        Node cur=this.head;//代表当前要反转的结点
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }

    //给定一个带有头节点的非空单链表，返回链表中的中间节点，
    // 如果有两个中间结点，则返回第二个中间节点
    public Node middleNode(){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }


    //输入一个链表，输出该链表的倒数第k个节点
    public Node findKthToTail(int k){
        if(k<0){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;
        //让fast先走k-1步
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("k过大");
                return null;
            }
        }
        //k已经走了k-1步了  让fast和slow一块走
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }

    //所有小于x的节点排在所有大于x的节点的左边
    public Node partition(int x){
        Node bs=null;
        Node be=null;

        Node as=null;
        Node ae=null;

        Node cur=this.head;
        while(cur!=null){
            if(cur.val<x){
                if(bs==null){
                    bs=cur;
                    be=bs;
                }else{
                    be.next=cur;
                    be=cur;
                }

            }else{
                if(as==null){
                    as=cur;
                    ae=as;
                }else{
                    ae.next=cur;
                    ae=cur;
                }


            }
            cur=cur.next;

        }
        //现在要将两部分合并到一块
        if(bs==null){
            return as;
        }
        be.next=as;
        if(as!=null){
            ae.next=null;
        }
        return bs;

    }


    //在一个排序的链表中，存在重复的结点，请删除重复的结点，重复的节点不保留，返回链表的头
    public Node deleteDuplication(){
        Node newHead=new Node(-1);
        Node tmp=newHead;

        Node cur=this.head;
        while(cur!=null){
           if(cur.next!=null&&cur.val==cur.next.val){
               //相等的时候
               while(cur.next!=null&&cur.val==cur.next.val){
                   cur=cur.next;
               }
               cur=cur.next;
           }else{
               //不相等的时候
               tmp.next=cur;
               tmp=cur;
               cur=cur.next;

           }
        }
        tmp.next=null;
        return newHead.next;
    }


    //判断链表是否是回文结构
    public boolean chkPalindrom(){
        if(head==null){
            return false;
        }
        if(head.next==null){
            //只有一个节点的时候
            return true;
        }
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node cur=slow.next;
        while(cur!=null){
            Node curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //现在要从两边开始进行判断
        while(slow!=head){

            if(slow.val!=head.val){
                return false;
            }
            if(head.next==slow){
                return true;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;



    }


    //给定一个链表，判断是否有环
    public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }



    //给定一个链表，返回入环的第一个节点
    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }




}





















