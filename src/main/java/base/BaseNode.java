package base;

public class BaseNode<T>{
    private T val;
    protected BaseNode<T> next;

    public BaseNode(T t) {
        this.val = t;
    }

    public BaseNode(T t, BaseNode<T> next) {
        this.val = t;
        this.next = next;
    }
}
