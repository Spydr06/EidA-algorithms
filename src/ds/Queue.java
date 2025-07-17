package ds;

public class Queue<T> extends Array<T> {
    int head, tail;

    public Queue(int size) {
        super(size);
    }

    public void enqueue(T x) {
        set(tail++, x);
        if(tail == size())
            tail = 0;
    }

    public T dequeue() {
        T x = get(head++);
        if(head == size())
            head = 0;
        return x;
    }
}
