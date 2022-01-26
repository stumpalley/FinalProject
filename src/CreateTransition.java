public class CreateTransition {
    
    public TransitionInterface MakeTransition(State s, int i, int j) {
        if (s.getInfo().getMaze().getType() == 1) {

            return new Transition1(s,i);
        }

        if (s.getInfo().getMaze().getType() == 2) {

            return new Transition2(s,i);
        }

        if (s.getInfo().getMaze().getType() == 3) {

            return new Transition3(s,i,j);
        }
        return null;
    }
}
