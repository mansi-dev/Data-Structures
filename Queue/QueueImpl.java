class Queue {
    int front, rear, size;
    int capactiy;
    int array[];

    // initalize front, rear and array
    public Queue(int capactiy) {
        this.capactiy = capactiy;
        this.front = this.size = 0;
        this.rear = capactiy - 1;
        array = new int[this.capactiy];
    }

    // check if queue is full, it is full when size is equal to the capacity
    boolean isFull(Queue queue) {
        return (queue.size == queue.capactiy);
    }

    // check if queue is empty, it is empty when size is 0
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    // function to add elements to the queue
    void enqueue(int item) {
        if (isFull(this)) {
            return;
        }
        this.rear = (this.rear + 1) % this.capactiy;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out
                .println(item + " enqueued to the queue with front= " + front + " ,rear= " + rear + " ,size= " + size);
    }

    // function to delete elements from the queue
    int dequeue() {
        if (isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capactiy;
        this.size = this.size - 1;
        return item;
    }

    // function to get the front of queue
    int front() {
        if (this.isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    // function to get the front of queue
    int rear() {
        if (this.isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }
}

public class QueueImpl {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        queue.enqueue(100);

        System.out.println(queue.dequeue() + " dequeued from queue\n");
      
        System.out.println("Front item is " + queue.front());
         
        System.out.println("Rear item is " + queue.rear());
    }
}
