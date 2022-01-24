public interface TransitionInterface {
    public State getNextState();
    public boolean outOfBounds();
    public Location getNextLocation();
    public Location getCurrLocation();
    public State getCurrState();
}
