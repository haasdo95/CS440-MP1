import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void testFile2Maze() throws IOException {
        Maze maze = Utils.file2Maze("mediumMaze.txt");
        assertEquals(maze.maze[21][1], new Node(21, 1, false, true, null));
        System.out.print(maze.maze[0][59].isWall);
    }

}