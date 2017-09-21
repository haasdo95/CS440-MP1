import java.util.Comparator;

public class AStarComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        if (n1.aStarHeuristic() < n2.aStarHeuristic()) {
            return -1;
        }
        if (n1.aStarHeuristic() > n2.aStarHeuristic()) {
            return 1;
        }
        // using traveled distance to break tie.
        if (n1.traveled < n2.traveled) {
            return -1;
        }
        if (n1.traveled > n2.traveled) {
            return 1;
        }
        return 0;
    }
}
