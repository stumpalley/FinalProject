
public interface CS112QueueInterface {

	void writeQueue();

	void enqueue(State j);

	State dequeue();

	boolean isEmpty();
	
	State peek();

	int getCount();

}