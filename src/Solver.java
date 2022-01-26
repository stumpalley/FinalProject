import java.util.ArrayList;


public class Solver {
    private CS112QueueInterface theQ = new CS112QueueB();
    private Maze maze;
    private ArrayList<State> visited = new ArrayList<State>();
    private ArrayList<Integer[]> visited3 = new ArrayList<Integer[]>();
    private State start;
    private State last;

    public Solver(Maze m) {
        maze = m;
        start = new State(maze.getLocationAt(maze.getStartX(), maze.getStartY()));
        //last = new State(maze.getLocationAt(maze.getGoalX(), maze.getGoalY()));
        
    }

    public void solve() {
        visited.add(start);
        theQ.enqueue(start);/* 
        theQ.writeQueue(); */


        // DEBUG
        //System.out.println(newX +" " +newY);
        //System.out.println(direction);
        //System.out.println(a);
        //System.out.println(newX +" "+newY);
        Integer[] a= {2,5,3};
        Integer[] b= {3,0,4};
        visited3.add(a);
        visited3.add(b);
         
        while (!theQ.isEmpty()) {
            
            State node = theQ.dequeue();
            if(maze.getType() != 3){
                visited.add(node);
            }/* 
            if(!hasVisit(node.getLocation()))System.out.println("wtf"); */
            node.getLocation().generateTransitions();
            
            if(checkTransitions(node) == true) {
                while(theQ.getCount()!=0) {
                    theQ.dequeue();
                }
                /* DEBUG
                for(State s : visited) {
                    System.out.println();
                    System.out.println("visited");
                    System.out.println(s.getLocation().getX()+ " "+s.getLocation().getY());
                }*/
                //theQ.writeQueue(); 
                break;
            }
        }


    }

    public boolean checkLast() {
        if (maze.getGoalX() == last.getLocation().getX() && maze.getGoalY() == last.getLocation().getY()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasVisit(TransitionInterface i) {
        for (State j : visited) {
            if(j.getLocation().getX() == i.getNextLocation().getX() && j.getLocation().getY() == i.getNextLocation().getY()) {
                return true;
            }
        }
        if (maze.getType() == 3) {
            for (Integer[] k : visited3) {
                if(k[0] == i.getNextLocation().getX() && k[1] == i.getNextLocation().getY() && k[2] == i.getCurrDirection())
                {return true;}
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
            
            if (hasVisit(transition) ) {
                continue;
            }
            
            State next = new State(loc, node);
            
            
            node.addChild(next);
            if (maze.getType() != 3){
                visited.add(next);
            }
            else if (maze.getType() == 3) {
                Integer[] temp = {loc.getX(), loc.getY(), transition.getCurrDirection()};
                visited3.add(temp);
            }
            

            last = next;
            
            if (loc.getX() == maze.getGoalX() && loc.getY() == maze.getGoalY()) {
                /* System.out.println(1); */
                last = next;
                return true;
            }
            theQ.enqueue(next);
            
        }
        //System.out.println(3);
        return false;
    }

    public int getSteps() {
        State s = last;
        int steps = 0;
        while(s.getParent() != null) {
            steps++;
            s = s.getParent();
        }
        return steps;
    }
}
