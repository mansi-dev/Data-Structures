import java.util.Stack;

public class QueueUStack2 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    void enqueue(int item){
        stack1.push(item);
    }

    int dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("Queue is empty");
            System.exit(0);
        }

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int x = stack2.pop();
        return x;
    }

    public static void main(String[] args) {
        QueueUStack2 qs = new QueueUStack2();
        qs.enqueue(1);
        qs.enqueue(3);
        qs.enqueue(2);
        qs.enqueue(4);
        qs.enqueue(5);

        System.out.println(qs.dequeue());
        qs.enqueue(6);
        System.out.println(qs.dequeue());
        System.out.println(qs.stack1.peek());

    }
}
