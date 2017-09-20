import java.util.Comparator;

public class GreedyComparator implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.heuristic() < n2.heuristic()) {
            return -1;
        }
        else if (n1.heuristic() > n2.heuristic()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
