class Node<T>{
	T data; 
	Node next; 

	public Node(Object data){
		this.data = (T) data; 
	}
}


public class LinkedList <T> implements List<T>{

	Node<T> head; 
	int size; 

	public LinkedList(){
		T head = null; 
		int size = 0; 
	}
	

	public void add(int pos, T item){
		if(pos>size|| pos<0){
			System.out.println("The position is out of bounds in the list"); 
		}

		if(pos == 0){
			Node<T>current = new Node<T>(item);
			current.next = head; 
			head = current; 
			++size; 
		}
		else{
			Node<T> current = new Node<T>(item); 
			Node<T> prev = head; 
			for(int i = 0; i <pos-1; i++){
				prev = prev.next; 
			}
			current.next = prev.next; 
			prev.next = current; 
			++size; 
		}
	}

	public void add(T item){
		if(head == null){
			head = new Node<T>(item); 
			++size; 
		}
		else{
			Node<T>prev = head; 
			while(prev.next != null){
				prev = prev.next; 
			}
		
			Node<T>curr = new Node<T>(item); 
			prev.next = curr; 
			++size; 

		}
	}

	public T get(int pos)throws IndexOutOfBoundsException{
		if(pos>=size||pos<0){
			throw new IndexOutOfBoundsException("does not exist"); 
		}
		Node prev = head;  
		for(int i =0; i <pos; i++){
			prev = prev.next; 
		}
		return (T)prev.data; 

	}

	public T remove(int pos)throws IndexOutOfBoundsException{
		if(pos > size-1 || pos <0){
			throw new IndexOutOfBoundsException("does not work"); 
		}
		if(pos == 0){
			T item = (T) head.data; 
			head = head.next; 
			size--; 
			return item; 
		}
		else{
			Node prev = head; 
			Node<T>current = prev; 
			for(int i =0; i < pos-1; i++){
				prev = prev.next; 
			}
			Node curr = prev.next;
			T item = (T) curr.data; 
			size--; 
			return item; 
		}
	}
	
	public int size(){
		return size; 
	}
}