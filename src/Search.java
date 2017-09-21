import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Search {

    public static Solution doSearch (Structure structure, Node[][] maze, int startx, int starty, int finalx, int finaly) {
        int height = maze.length;
        if(height == 0) return null;
        int width = maze[0].length;
        if(width == 0) return null;

        Node start = maze[startx][starty];
        structure.push(start);

        HashMap<Node, Node> parent = new HashMap<>(); //Record current path
        Node plc = null;
        parent.put(start, start);

        int numberOfExpandedNodes = 0;

        while(!structure.isEmpty())
        {
            Node temp = structure.pop();
            numberOfExpandedNodes++;

            if(temp.column < width - 1)    //Can move right
            {
                plc = maze[temp.row][temp.column + 1];
                if(plc.row == finalx && plc.column == finaly){
                    parent.put(plc, temp);
                    plc.isVisited = true;
                    break;
                }
                updateStructure(structure, parent, plc, temp);
            }
            if (temp.row < height - 1)    //Can move down
            {
                plc = maze[temp.row + 1][temp.column];
                if(plc.row == finalx && plc.column == finaly){
                    parent.put(plc, temp);
                    plc.isVisited = true;
                    break;
                }
                updateStructure(structure, parent, plc, temp);
            }
            if (temp.column > 0)   //Can move left
            {
                plc = maze[temp.row][temp.column-1];
                if(plc.row == finalx && plc.column == finaly){
                    parent.put(plc, temp);
                    plc.isVisited = true;
                    break;
                }
                updateStructure(structure, parent, plc, temp);
            }
            if(temp.row > 0)  //Can move up
            {
                plc = maze[temp.row-1][temp.column];
                if(plc.row == finalx && plc.column == finaly){
                    parent.put(plc, temp);
                    plc.isVisited = true;
                    break;
                }
                updateStructure(structure, parent, plc, temp);
            }

        }

        ArrayList<Node> solution = new ArrayList<>();

        // Now plc is the final node
        while(!parent.get(plc).equals(start))
        {
            solution.add(plc);
            plc = parent.get(plc);
        }

        return new Solution(solution, numberOfExpandedNodes);
    }

    private static void updateStructure(Structure structure, HashMap<Node, Node> parent, Node plc, Node temp) {
        if(!plc.isVisited && !plc.isWall) {
            parent.put(plc, temp);
            plc.isVisited = true;
            if (plc.traveled > temp.traveled + 1) {
                plc.traveled = temp.traveled + 1;
            }
            structure.push(plc);
        }
    }

    public static void main (String[] args) throws IOException {
        runOnMaze("tinyMaze.txt");
        runOnMaze("mediumMaze.txt");
        runOnMaze("bigMaze.txt");
        runOnMaze("openMaze.txt");
    }

    private static void runOnMaze(String filename) throws IOException {
        Maze maze = Utils.file2Maze(filename);
        assert maze != null;
        Solution solution = Search.doSearch(new MyStack(), maze.maze, maze.start.row, maze.start.column,
                maze.destination[0].row, maze.destination[0].column);
        for (Iterator<Node> iterator = solution.path.iterator(); iterator.hasNext(); ) {
            iterator.next().isSolution = true;
        }
        System.out.print(maze);
        System.out.println(solution.path.size() + " STEPS FOR DFS");
        System.out.println(solution.numberOfNodesExpanded + " NODES EXPANDED");
        System.out.println();

        maze = Utils.file2Maze(filename);
        assert maze != null;
        solution = Search.doSearch(new MyQueue(), maze.maze, maze.start.row, maze.start.column,
                maze.destination[0].row, maze.destination[0].column);
        for (Iterator<Node> iterator = solution.path.iterator(); iterator.hasNext(); ) {
            iterator.next().isSolution = true;
        }
        System.out.print(maze);
        System.out.println(solution.path.size() + " STEPS FOR BFS");
        System.out.println(solution.numberOfNodesExpanded + " NODES EXPANDED");
        System.out.println();

        maze = Utils.file2Maze(filename);
        assert maze != null;
        solution = Search.doSearch(new MyHeap(new GreedyComparator()), maze.maze, maze.start.row, maze.start.column,
                maze.destination[0].row, maze.destination[0].column);
        for (Iterator<Node> iterator = solution.path.iterator(); iterator.hasNext(); ) {
            iterator.next().isSolution = true;
        }
        System.out.print(maze);
        System.out.println(solution.path.size() + " STEPS FOR GREEDY");
        System.out.println(solution.numberOfNodesExpanded + " NODES EXPANDED");
        System.out.println();

        maze = Utils.file2Maze(filename);
        assert maze != null;
        solution = Search.doSearch(new MyHeap(new AStarComparator()), maze.maze, maze.start.row, maze.start.column,
                maze.destination[0].row, maze.destination[0].column);
        for (Iterator<Node> iterator = solution.path.iterator(); iterator.hasNext(); ) {
            iterator.next().isSolution = true;
        }
        System.out.print(maze);
        System.out.println(solution.path.size() + " STEPS FOR A-STAR");
        System.out.println(solution.numberOfNodesExpanded + " NODES EXPANDED");
        System.out.println();
    }
}
