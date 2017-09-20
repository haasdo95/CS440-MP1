import java.util.LinkedList;
public class MyQueue implements Structure {
    private LinkedList<Node> queue;

    MyQueue () {
        this.queue = new LinkedList<>();
    }

    @Override
    public void push(Node node) {
        this.queue.add(node);
    }

    @Override
    public Node pop() {
        return this.queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
