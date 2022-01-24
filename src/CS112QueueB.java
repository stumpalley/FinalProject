import javax.swing.DefaultCellEditor;

// Alex Yan
public class CS112QueueB implements CS112QueueInterface {
    private Node<State> theQ;
    private int front;
    private int back;
    private int count = 0;

    public CS112QueueB() {
        theQ = new Node<State>();
        front = 1;
        back = -1;
    }


    public void writeQueue() {
        System.out.print("Queue: ");
        int i = front;
        while(theQ.ith(i)!=null) {
            System.out.println(theQ.ith(i).print().getLocation().getX() +" " +theQ.ith(i).print().getLocation().getY());
            i++;
        }
        System.out.println();

    }

    public void enqueue(State j) {
        count++;
        theQ.ith(back+ 1).add(j);
        back++;
        
    }

    public State dequeue() {
        /* if(isEmpty()){
            return null;
        }
        front++;
        return theQ.ith(front).getName(); */
        back--;
        count--;
        return theQ.deleteIth(front).getName();
        
        
    }

    public boolean isEmpty() {
        return theQ.isEmpty();
    }

    public State peek() {
        return theQ.ith(front).getNext().getName();
    }
    
    public int getCount() {
        return count;
    }

}
