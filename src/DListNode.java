
public class DListNode<T> {
	private T data;
	private DListNode<T> prev;
	private DListNode<T> next;
	
	public DListNode(T data, DListNode<T> prev, DListNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public DListNode<T> getPrev() {
		return prev;
	}
	
	public void setPrev(DListNode<T> prev) {
		this.prev = prev;
	}
	
	public DListNode<T> getNext() {
		return next;
	}
	
	public void setNext(DListNode<T> next) {
		this.next = next;
	}
	
}
