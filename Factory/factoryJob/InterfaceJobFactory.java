package factoryJob;
import interfaces.AbstractJob;

public interface InterfaceJobFactory {
	
	public AbstractJob make (int i) throws IndexOutOfBoundsException;
	
	public AbstractJob[] getList();
	public int getSize();

}