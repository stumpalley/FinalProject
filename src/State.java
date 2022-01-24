public class State {
    private Location location;
    private Information info;
    private int status; // 0 = start, 1 = intermediate, 2 = end;

    public State(Location loc) {
        location = loc;
        info = location.getInfo();
        setStatus();
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
}

