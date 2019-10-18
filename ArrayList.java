import java.util.Arrays; 

public class ArrayList <T> implements List<T>{
	private T[] a; 
	private int size; 

	public ArrayList(){
		a = (T[]) new Object[10]; 
		size = 0; 
	}

	public void add(Object item){
		if(size == a.length){
			growArray(); 
		}
		a[size++] = (T) item; 
	}

	public void add(int pos, Object item) throws IndexOutOfBoundsException{
		if(pos < 0 || pos>size){
			throw new IndexOutOfBoundsException("does not work"); 
		}

		if(size == a.length){
			growArray(); 
		}

		for(int i =size; i >pos; i--){
			a[i] = a[i-1]; 
		}
		a[pos] = (T) item; 
		size++; 
	}

	public T get(int pos)throws IndexOutOfBoundsException{
		if(pos<0||pos>=size){
			throw new IndexOutOfBoundsException("does not work"); 
		}
		return a[pos]; 
	}

	public T remove(int pos)throws IndexOutOfBoundsException{
		if(pos<0 || pos>=size){
			throw new IndexOutOfBoundsException("does not work"); 
		}
		T item = a[pos]; 
		for(int i =pos; i<size-1; i++){
			a[i] = a[i+1]; 
		}
		size--; 
		return item; 
	}

	public int size(){
		return size; 
	}

	public void growArray(){
		int len = a.length; 
		T[] new_array = (T[]) new Object[len*2]; 
		for(int i = 0; i < a.length; i++){
			new_array[i] = a[i]; 
		}
		a = new_array; 
	}



}