import java.util.ArrayList;

public class Location {
    private int x, y;
    private ArrayList<TransitionInterface> transitions = new ArrayList<TransitionInterface>();
    private Information info;
    private int status = 1; // 0 = start, 1 = intermediate, 2 = end;

    public Location(int posX, int posY, Information i) {
        x=posX;
        y=posY;
        info = i;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStatus(int i) {
        status = i;
    }

    public int getStatus() {
        return status;
    }

    public ArrayList<TransitionInterface> getTransitions() {
        return transitions;
    }

    public Information getInfo() {
        return info;
    }

    public void generateTransitions() {
        for (int i = 0; i < info.getMaze().getNumDirections(); i++){
            CreateTransition c = new CreateTransition();
            TransitionInterface trans = c.MakeTransition(new State(this),i);
            if (!trans.outOfBounds()) {
                transitions.add(trans);
            }
        }
    }

}
