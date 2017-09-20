import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class contains the utilities to convert a txt file into a Node[][]
 */
public class Utils {
    static Maze file2Maze (String filename) throws IOException {
        FileInputStream fstream;
        try {
            fstream = new FileInputStream("mazes/" + filename);
        } catch (FileNotFoundException e) {
            System.out.println("FILE DOESN'T EXIST");
            return null;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        Node start = null;
        ArrayList<Node> dest = new ArrayList<>();

        ArrayList<ArrayList<Node>> maze = new ArrayList<>();

        String line;
        int row_number = 0;
        int column_number = 0;
        while ((line = br.readLine()) != null)   {
            ArrayList<Node> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                column_number = line.length();

                if (line.charAt(i) == 'P') { // start
                    start = new Node(row_number, i, false, true, null);
                    row.add(start);
                }
                else if (line.charAt(i) == '.') { // end
                    Node newNode = new Node(row_number, i, false, false, null);
                    dest.add(newNode);
                    row.add(newNode);
                }
                else if (line.charAt(i) == '%') {
                    row.add(new Node(row_number, i, true, false, null));
                }
                else {
                    row.add(new Node(row_number, i, false, false, null));
                }
            }
            maze.add(row);
            row_number++;
        }
        br.close();
        assert start != null;
        start.traveled = 0;

        ArrayList<Node[]> mazeProc = new ArrayList<>();
        for (Iterator<ArrayList<Node>> iter = maze.iterator(); iter.hasNext(); ) {
            ArrayList<Node> lst = iter.next();
            mazeProc.add(lst.toArray(new Node[lst.size()]));
        }

        Node[][] ret_maze = mazeProc.toArray(new Node[mazeProc.size()][]);

        Maze retValue = new Maze(ret_maze, start, dest.toArray(new Node[dest.size()]));
        for (int x = 0; x < ret_maze.length; x++) {
            for (int y = 0; y < ret_maze[0].length; y++) {
                ret_maze[x][y].maze = retValue;
            }
        }
        return retValue;
    }
}
