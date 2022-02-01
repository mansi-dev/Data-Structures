import java.util.ArrayList;
import java.util.List;

public class CircularQueue {
    private int size, front, rear;
    private List<Integer> queue = new ArrayList<>();

    // initalize the size, front and rear of the queue
    public CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }

    // function to insert a new element in the queue
    public void enqueue(int item) {
        // check if queue is full
        if ((this.front == 0 && this.rear == this.size - 1) ||
                (this.rear == (this.front - 1) % (this.size - 1))) {
            System.out.println("Queue is full");
        } else if (this.front == -1) {
            // if queue is empty
            this.front = 0;
            this.rear = 0;
            queue.add(rear, item);
        } else if (this.rear == this.size - 1 && this.front != 0) {
            // if queue is not full and space is left after deleting elements
            this.rear = 0;
            queue.set(rear, item);
        } else {
            this.rear = this.rear + 1;
            if (this.front <= this.rear) {
                queue.add(this.rear, item);
            } else {
                queue.set(this.rear, item);
            }
        }
    }

    // function to remove an element from the queue
    public int dequeue() {
        int temp;

        // check if queue is empty
        if (this.front == -1) {
            return -1;
        }

        temp = queue.get(this.front);

        // condition for only one element
        if (this.front == this.rear) {
            front = -1;
            rear = -1;
        } else if (this.front == this.size - 1) {
            this.front = 0;
        } else {
            this.front = this.front + 1;
        }
        return temp;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
     
        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(13);
        q.enqueue(-6);
        
        int x = q.dequeue();
    
        // Checking for empty queue.
        if(x != -1){
            System.out.print("Deleted value = ");
            System.out.println(x);
        }
        q.enqueue(9);
        q.enqueue(20);
        q.enqueue(5);
    }
 
}
