public class Node {
    int row;
    int column;
    int traveled;

    Maze maze;

    boolean isVisited;
    boolean isWall;
    boolean isSolution;

    Node (int row, int column, boolean isWall, boolean isVisited, Maze maze) {
        traveled = 999; // big enough
        this.row = row;
        this.column = column;
        this.isVisited = isVisited;
        this.isWall = isWall;
        this.isSolution = false;
        this.maze = maze;
    }

    @Override
    public String toString() {
        if (this.isSolution) {
            return "7";
        }
        if (this.isWall) {
            return "%";
        }
        return " ";
    }

    int aStarHeuristic () {
        return this.heuristic() + this.traveled;
    }

    int heuristic () { // manhattan distance
        return Math.abs(this.row - maze.destination[0].row)
                + Math.abs(this.column - maze.destination[0].column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return ((Node) obj).row == this.row && ((Node) obj).column == this.column;
        }
        return false;
    }
}
