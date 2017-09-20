import java.util.Stack;
public class MyStack implements Structure {

    private Stack<Node> stack;

    MyStack () {
        this.stack = new Stack<>();
    }

    @Override
    public void push(Node node) {
        this.stack.push(node);
    }

    @Override
    public Node pop() {
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.empty();
    }
}
