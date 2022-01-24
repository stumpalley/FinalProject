public class State {
    private Location location = null;
    private Information info;
    private int status; // 0 = start, 1 = intermediate, 2 = end;
    private State parent = null;

    public State(Location loc) {
        location = loc;
        info = location.getInfo();
        setStatus();
    }

    public State(Location loc, State parent) {
        this.location = loc;
        info = location.getInfo();
        this.parent = parent;
    }
    
    public Location getLocation() {
        return location;
    }

    public Information getInfo() {
        return info;
    }

    private void setStatus() {
        status = location.getStatus();
    }

    public boolean isGoal() {
        return status == 2;
    }

    public void addChild(State s) {
        s.addParent(this);
        
    }
    public void addParent(State s) {
        this.parent = s;
    }

    public State getParent() {
        return parent;
    }
}

