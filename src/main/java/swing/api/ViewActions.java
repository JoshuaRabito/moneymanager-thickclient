package swing.api;

public interface ViewActions<T> {
	
	public void bindListeners();
	public void populateCombos();
	public T getView();
	public void clearForm();

}
