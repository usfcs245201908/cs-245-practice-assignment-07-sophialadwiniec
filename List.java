
public interface List<T> {
	
	public void add(T item);
	public void add(int pos, T item);
	public T get(int pos);
	public T remove(int pos);
	public int size();

}
