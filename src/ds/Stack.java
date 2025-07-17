package ds;

public class Stack<T> extends Array<T> {
    private int top;

    public Stack(int size) {
        super(size);
    }

    public boolean empty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    public T top(T x) {
        if(empty())
            return null;
        return get(0);
    }

    public void push(T x) {
        if(top == size())
            throw new IndexOutOfBoundsException();

        set(top++, x);
    }

    public void pop(T x) {
        if(empty())
            throw new IndexOutOfBoundsException();

        set(top--, x);
    }
}
