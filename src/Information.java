public class Information {
    private int numToMove;
    private int[][] directions;
    private Maze maze;
    private int status;
    private int[] goal = new int[2];

    public Information(int x, int y, Maze input) {
        maze = input;
        numToMove = maze.getValue(x, y);
        goal[0] = maze.getGoalX();
        goal[1] = maze.getGoalY();
        directions = makeDirectionMatrix(input.getNumDirections(), numToMove);
        if (x == goal[0] && y == goal[1]) {
            status = 2;
        }
    }

    public int getNumToMove() {
        return numToMove;
    }

    public int[][] getDirections() {
        return directions;
    }

    public int getStatus() {
        return status;
    }

    public Maze getMaze() {
        return maze;
    }

    private int[][] makeDirectionMatrix(int numDirections, int numToMove) {

        /*
            INDEX 0 = RIGHT
            INDEX 1 = UP
            INDEX 2 = LEFT
            INDEX 3 = DOWN
        */

        int[][] matrix = new int[numDirections][2];
        int x = numToMove;
        int y = 0;
        for (int i = 0; i < numDirections; i++) {
            matrix[i][0] = x;
            matrix[i][1] = y;

            int temp = x;
            x = -y;
            y = temp;
        }

        return matrix;
    }
}
