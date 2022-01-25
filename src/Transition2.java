

public class Transition2 implements TransitionInterface {
    private State st;
    private Location currLoc;
    private Location nextLoc = null;
    private int direction;
    private int directions[][] = new int[1][2];;
    private int newX, newY;

    /*
        1 - RIGHT = U+1F816
        2 - DOWN = U+1F817
        3 - UP = U+1F815
        4 - LEFT = U+1F814

        5 - UP RIGHT = U+2B08
        6 - UP LEFT = U+2B09
        7 - DOWN RIGHT = U+2B0A
        8 - DOWN LEFT = U+2B0B
    */

    public Transition2(State s, int dir) {
        st = s;
        currLoc = st.getLocation();
        direction = s.getInfo().getMaze().getValue(currLoc.getX(), currLoc.getY());
        System.out.println(direction);
        getDirection();
        System.out.println("CUYRRENT: " +currLoc.getX() +" " +currLoc.getY());
        System.out.println(directions[0][1] +" " +directions[0][0]);
        newX = currLoc.getX() + (directions[0][1] * (dir + 1));
        newY = currLoc.getY() + (directions[0][0] * (dir + 1));
        
            if (newX >= 0 && newY >= 0){
                if(newX <= 7 && newY <= 7) {

                    if(st.getInfo().getMaze().getBoardDataAt(currLoc.getX(), currLoc.getY()) != st.getInfo().getMaze().getBoardDataAt(newX, newY)){
                        // nextLoc = new Location(newX, newY, currLoc.getInfo().getMaze().getInfoAt(newX, newY));
                        nextLoc = st.getInfo().getMaze().getLocationAt(newX, newY);
                        System.out.println(newX +" " +newY);
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

    private void getDirection() {
        switch (direction) {
            case 1: 
                directions[0][0] = 1;
                directions[0][1] = 0;
                break;
            case 2: 
                directions[0][0] = 0;
                directions[0][1] = 1;
                break;
            case 3: 
                directions[0][0] = 0;
                directions[0][1] = -1;
                break;
            case 4: 
                directions[0][0] = -1;
                directions[0][1] = 0;
                break;
            case 5: 
                directions[0][0] = 1;
                directions[0][1] = -1;
                break;
            case 6: 
                directions[0][0] = -1;
                directions[0][1] = -1;
                break;
            case 7: 
                directions[0][0] = 1;
                directions[0][1] = 1;
                break;
            case 8: 
                directions[0][0] = -1;
                directions[0][1] = 1;
                break;
        }
    }
}
