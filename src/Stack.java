
public class Stack<T> extends DoublyLinkedList<T> {
	
	public boolean isEmpty() {
		return head != null;
	} // end isEmpty()
	
	/**
	 * Assumes the stack is not empty
	 * @return
	 */
	public T pop() {
		T result = head.getData();
		deleteNode(head);
		return result;
	} // end pop()
	
	public void push(T data) {
		addToFront(data);
	} // end push()
	
} // end Stack class
