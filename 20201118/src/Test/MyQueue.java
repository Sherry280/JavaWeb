package Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MyQueue {
    //用栈实现队列的操作
    Stack<Integer> stack1=new Stack<>();//进队列的
    Stack<Integer> stack2=new Stack<>();//出队列的

    public void push(int x){
        stack2.push(x);
    }

    public int pop(){
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                Integer e=stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.pop();
    }


    public int peek(){
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                Integer e=stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.peek();
    }










    //用队列实现栈的操作
//    private Deque<Integer> s1;
//    private Deque<Integer> s2;
//
//    public MyQueue(){
//        s1=new LinkedList<>();
//        s2=new LinkedList<>();
//    }
//
//    public void push(int x){
//
//    }

}
