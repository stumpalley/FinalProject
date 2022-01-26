import java.util.ArrayList;

/*
    RIGHT = 0
    UP = 1
    LEFT = 2
    DOWN = 3
*/


public class Transition1 implements TransitionInterface {
    private State st;
    private Location currLoc;
    private Location nextLoc = null;
    private int direction;
    private int directions[][];
    private int newX, newY;

    public Transition1(State s, int direction) {
        st = s;
        currLoc = st.getLocation();
        directions = currLoc.getInfo().getDirections();

        
        newX = currLoc.getX() + directions[direction][0];
        newY = currLoc.getY() + directions[direction][1];
        if (newX >= 0 && newY >= 0){
            if(newX <= 6 && newY <= 6) {
                // nextLoc = new Location(newX, newY, currLoc.getInfo().getMaze().getInfoAt(newX, newY));
                nextLoc = st.getInfo().getMaze().getLocationAt(newX, newY);
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
        return 0;
    }
}
