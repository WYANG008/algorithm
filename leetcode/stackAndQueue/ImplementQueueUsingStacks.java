package stackAndQueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> wrightStack;
    private Stack<Integer> readStack;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        this.wrightStack = new Stack<>();
        this.readStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

//      if( this.wrightStack.isEmpty()) {
//            // read to stack and push
//            while(!this.readStack.isEmpty()) {
//                this.wrightStack.push(this.readStack.pop());
//            }
//        }
        this.wrightStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.readStack.isEmpty()) {

            while(!this.wrightStack.isEmpty()) {
                this.readStack.push(this.wrightStack.pop());
            }

        }
        return this.readStack.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(this.readStack.isEmpty()) {

            while(!this.wrightStack.isEmpty()) {
                this.readStack.push(this.wrightStack.pop());
            }

        }
        return this.readStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.readStack.isEmpty() && this.wrightStack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
