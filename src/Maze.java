public class Maze {
    Node[][] maze;
    Node start;
    Node[] destination;

    Maze (Node[][] maze, Node start, Node[] destination) {
        this.maze = maze;
        this.start = start;
        this.destination = destination;
    }

    @Override
    public String toString() {
        String vis = "";
        for (int x = 0; x < this.maze.length; x++) {
            for (int y = 0; y < this.maze[0].length; y++) {
                vis += this.maze[x][y].toString();
            }
            vis += "\n";
        }
        return vis;
    }
}
