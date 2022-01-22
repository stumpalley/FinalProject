import java.io.File;

public class Test {
    public static void main(String[] args) {
        System.out.println(new File("Maze.txt").getAbsoluteFile());
        System.out.println(new File("Maze.txt").exists());
        System.out.println(new File("Maze.txt").isDirectory());
        System.out.println(new File("Maze.txt").canRead());
    }
}
