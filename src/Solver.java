import java.util.ArrayList;


public class Solver {
    private CS112QueueInterface theQ = new CS112QueueB();
    private Maze maze;
    private ArrayList<State> visited = new ArrayList<State>();
    private State start;
    private State last;

    public Solver(Maze m) {
        maze = m;
        start = new State(maze.getLocationAt(maze.getStartX(), maze.getStartY()));
        last = new State(maze.getLocationAt(maze.getGoalX(), maze.getGoalY()));
        
    }

    public void solve() {
        visited.add(start);
        theQ.enqueue(start);
        theQ.writeQueue();
        while (!theQ.isEmpty()) {
            
            theQ.writeQueue();
            State node = theQ.dequeue();
            visited.add(node);
            if(!hasVisit(node.getLocation()))System.out.println("wtf");
            node.getLocation().generateTransitions();
            
            if(checkTransitions(node) == true) {
                while(theQ.getCount()!=0) {
                    theQ.dequeue();
                }
                for(State s : visited) {
                    System.out.println();
                    System.out.println("visited");
                    System.out.println(s.getLocation().getX()+ " "+s.getLocation().getY());
                }
                theQ.writeQueue();
                break;
            }
        }
    }

    public boolean hasVisit(Location i) {
        for (State j : visited) {
            if(j.getLocation().getX() == i.getX() && j.getLocation().getY() == i.getY()) {
                return true;
            }
        }
        return false;
    }


    public State getFinalState() {
        return last;
    }

    private boolean checkTransitions(State node) {
        
        for (TransitionInterface transition : node.getLocation().getTransitions()) {
            Location loc = transition.getNextLocation();
            
            System.out.println(loc.getX() +" " +loc.getY());
            if (hasVisit(loc)) {
                System.out.println("visited");
                continue;
            }
            
            State next = new State(loc, node);
            
            
            node.addChild(next);
            
            visited.add(next);
            last = next;
            
            if (loc.getX() == maze.getGoalX() && loc.getY() == maze.getGoalY()) {
                System.out.println(1);
                last = next;
                return true;
            }
            theQ.enqueue(next);
            
        }
        //System.out.println(3);
        return false;
    }
}
