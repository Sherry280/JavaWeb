package LinkedList;

public class Node {
    public Node next;
    public int val;
    public Node(int key){
        this.val=key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
