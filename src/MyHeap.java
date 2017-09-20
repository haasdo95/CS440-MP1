import java.util.Comparator;
import java.util.PriorityQueue;
public class MyHeap implements Structure {
    private PriorityQueue<Node> heap;

    MyHeap (Comparator<Node> comparator) {
        this.heap = new PriorityQueue<>(32, comparator);
    }

    @Override
    public void push(Node node) {
        this.heap.add(node);
    }

    @Override
    public Node pop() {
        return this.heap.remove();
    }

    @Override
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }
}
