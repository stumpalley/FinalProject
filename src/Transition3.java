import java.time.Year;

public class Transition3 implements TransitionInterface {
    private State st;
    private Location currLoc;
    private Location nextLoc = null;
    private int shape;
    private int color;
    private int direction;
    private int a;
    private int newDirection;
    private int directions[][] = new int[4][2];;
    private int newX, newY;

    public Transition3(State s, int dir,int loops) {
        st = s;
        currLoc = st.getLocation();
        shape = s.getInfo().getMaze().getValue(currLoc.getX(), currLoc.getY());
        color = st.getInfo().getMaze().getBoardDataAt(currLoc.getX(), currLoc.getY());
        direction = st.getInfo().getCurrDirection();
        a=dir + 1;
        //System.out.println(direction);
        getDirection();
        //System.out.println("CUYRRENT: " +currLoc.getX() +" " +currLoc.getY());
       //System.out.println(directions[dir][1] +" " +directions[dir][0]);
        
        int currX = currLoc.getX();
        int currY = currLoc.getY();
        Maze maze = st.getInfo().getMaze();

        newX = currLoc.getX() + (directions[dir][0] * (loops + 1));
        newY = currLoc.getY() + (directions[dir][1] * (loops + 1));
        /* if (dir + 1 == direction){
            return;
        } */
        /* if (st.getInfo().getPastDirections().contains(a)) {
            return;
        } */
        if (newX >= 0 && newY >= 0 && !checkUTurn()){
            
            if(newX <= 5 && newY <= 5) {
                //System.out.println(color == st.getInfo().getMaze().getBoardDataAt(newX, newY));
        //System.out.println(shape == st.getInfo().getMaze().getValue(newX, newY));
        //System.out.println("---------------------");
                if(color == st.getInfo().getMaze().getBoardDataAt(newX, newY) ||
                    shape == st.getInfo().getMaze().getValue(newX, newY)){
                    // nextLoc = new Location(newX, newY, currLoc.getInfo().getMaze().getInfoAt(newX, newY));
                    nextLoc = st.getInfo().getMaze().getLocationAt(newX, newY);
                    
                    st.getInfo().getMaze().getInfoAt(newX, newY).addDirectionToList(a);
                    setDirection(newX,newY);

                    /* System.out.println(getCurrDirection());
                    System.out.println(direction);
                    System.out.println(); */
                    //System.out.println(newX +" " +newY);
                    //System.out.println(direction);
        //System.out.println(a);
                    //System.out.println(newX +" "+newY);
                }
            }
        }
        
    }

    public Location getNextLocation() {
        
        return nextLoc;
    }

    public Location getCurrLocation() {
        return currLoc;
    }

    public State getCurrState() {
        return st.getParent();
    }

    public State getNextState() {
        return new State(nextLoc);
    }

    public boolean outOfBounds() {
        if (nextLoc == null) {
            return true;
        }
        return false;

        
    }

    public int getCurrDirection() {
        return a;
    }

    private void getDirection() {
        directions[0][0] = 0;
        directions[0][1] = 1;
        directions[1][0] = 1;
        directions[1][1] = 0;
        directions[2][0] = -1;
        directions[2][1] = 0;
        directions[3][0] = 0;
        directions[3][1] = -1;
    }

    private int setDirection(int x, int y) {
        Maze maze = st.getInfo().getMaze();
        /* if (x > currLoc.getX()) {maze.getInfoAt(newX, newY).setCurrDirection(3); return 3;}
        if (x < currLoc.getX()) {maze.getInfoAt(newX, newY).setCurrDirection(2);return 2;}
        if (y > currLoc.getY()) {maze.getInfoAt(newX, newY).setCurrDirection(1);return 1;}
        if (y < currLoc.getY()) {maze.getInfoAt(newX, newY).setCurrDirection(4);return 4;}
        return 0; */
        maze.getInfoAt(x, y).setCurrDirection(a);
        return 0;
    }



    private boolean checkUTurn() {
        if(a==3 && direction==2) {
            return true;
        }
        else if(a==2 && direction==3) {
            return true;
        }
        else if(a==1 && direction==4) {
            return true;
        }
        else if(a==4 && direction==1) {
            return true;
        }
        return false;
    }

    // 1 = right, 2 = down, 3 = up, 4 = left
}
