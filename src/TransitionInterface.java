public interface TransitionInterface {
    public State getNextState();
    public boolean outOfBounds();
    public Location getNextLocation();
}
