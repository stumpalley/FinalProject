// Alex Yan

public class Node<V> {

	private V name;
	private Node<V> next;


	// create a header
	public Node() {
		name = null;
		next = null;
	}

	public boolean odd() {
		if (getNext() == null) 
			return false;
		else 
			return getNext().oddHeaderless();
	}

	public boolean oddHeaderless() {
		if (getNext() == null)
			return true;
		else return !getNext().oddHeaderless();
	}


	public Node<V> ith(int i) {
		/* Node<V> current = this;
		int count = 0;
		
		while(getNext() != null) {
			if (count == i){
				return current;
			}
			count++;
			current=current.next;
		}
		return null; */
		if (i == 0) {
			return this;
		}
		if (getNext() == null) {
			return null;
		}
		return getNext().ithHeaderless(i-1);

	}

	private Node<V> ithHeaderless(int i) {
		
		if (i == 0) {
			return this;
		}
		if (getNext() == null) {
			return null;
		}
		return getNext().ithHeaderless(i-1);	
	}

	public void doubleList() {
		/* while(this != null){
			if (getNext() == null){
				for (int i = 0; i < length(); i++) {
					next = new Node<V>();
					getNext().name = ith(i).name;
				}
			}
			
			else {getNext().doubleList();}
		} */
		int length = length();
		int index = 1;

		while (length() != length*2 ) {
			add(ith(index).name);
			index++;
			
		}
		
		
	}

	public void add(V d) {
		if (getNext()==null) {
			next = new Node<V>();
			getNext().name = d;
		}
		else getNext().add(d);
	}

	public boolean isEmpty() {
		return getNext()==null;
	}

	public int length() {
		if (isEmpty()) return 0;
		else return getNext().lengthHeaderless();
	}

    private int lengthHeaderless() {
		if (getNext() == null) return 1;
		else return 1+getNext().lengthHeaderless();
	}




	public void print() {
		System.out.println(name);
		if (getNext() != null)
			getNext().print();
	}


	public boolean sameList(Node<V> st) {
		if (st.getNext() == null && getNext() == null)
			return true;
		if (st.getNext() == null || getNext() == null)
			return false;
		else return getNext().sameListHeaderless(st.getNext());

	}

	private boolean sameListHeaderless(Node<V> st) {

		if (!name.equals(st.name))
			return false;
		if (getNext() == null && st.getNext() == null)
			return true;
		if (getNext() == null || st.getNext() == null)
			return false;
		return getNext().sameListHeaderless(st.getNext());
	}

	public Node<V> getNext() {
		return next;
	}

	public V getName() {
		return name;
	}

	public String toString() {
		return super.toString()+"  "+name;
	}

    public Node<V> deleteIth(int i) {
		Node<V> current = new Node<V>();
		current = ith(i);
		Node<V> prev = new Node<V>();
		prev = ith(i-1);
		Node<V> ith = new Node<V>();
		ith.name = prev.name;
		ith.next = prev.next;

		prev.next = current.next;
		return current;

    }

}
