package factory;

public interface InterfaceJobFactory {
	
	public InterfaceJob make (int i) throws IndexOutOfBoundsException;
	
	public int numberJob();

}