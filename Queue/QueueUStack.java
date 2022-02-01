import java.util.Stack;

/*
 * Method 1 of implementing queue using stack.
 * This method moves all the element twice in enqueue operation.
 * 
*/
public class QueueUStack {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    void enqueue(int x){
        // move all elements from stack1 to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    int dequeue(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty");
            System.exit(0);
        }

        int x = stack1.peek();
        stack1.pop();
        return x;
    }

    public static void main(String[] args) {
        QueueUStack qs = new QueueUStack();
        qs.enqueue(1);
        qs.enqueue(3);
        qs.enqueue(2);
        qs.enqueue(4);
        qs.enqueue(5);

        System.out.println(qs.dequeue());
    }
}
