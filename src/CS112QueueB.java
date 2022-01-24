// Alex Yan
public class CS112QueueB implements CS112QueueInterface {
    private Node<Integer> theQ;
    private int front;
    private int back;

    public CS112QueueB() {
        theQ = new Node<Integer>();
        front = 0;
        back = -1;
    }


    public void writeQueue() {
        System.out.print("Queue: ");

        theQ.ith(front+1).print();

    }

    public void enqueue(int j) {
        
        theQ.ith(back+ 1).add(j);
        back++;
        
    }

    public int dequeue() {
        if(isEmpty()){
            return -981293;
        }
        front++;
        return theQ.ith(front).getName();
    }

    public boolean isEmpty() {
        return theQ.isEmpty();
    }

    public int peek() {
        return theQ.ith(front).getNext().getName();
    }

}
