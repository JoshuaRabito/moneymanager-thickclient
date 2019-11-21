package swing.api;

public interface ViewActions<T> {
	
	public void bindListeners();
	public T getView();
	public void clearForm();
	public void close();

}
