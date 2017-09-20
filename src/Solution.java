import java.util.ArrayList;

public class Solution {
    ArrayList<Node> path;
    int numberOfNodesExpanded;

    Solution (ArrayList<Node> path, int numberOfNodesExpanded) {
        this.numberOfNodesExpanded = numberOfNodesExpanded;
        this.path = path;
    }
}
