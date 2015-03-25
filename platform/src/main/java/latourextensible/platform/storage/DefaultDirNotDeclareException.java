package latourextensible.platform.storage;

import java.lang.Exception;
import java.lang.String;
import java.lang.Throwable;

public class DefaultDirNotDeclareException extends Exception {
	
	public DefaultDirNotDeclareException() {
		super();
	}
	
	public DefaultDirNotDeclareException(String detailMessage) {
		super(detailMessage);
	}
	
	public DefaultDirNotDeclareException(String detailMessage, Throwable throwable) {
		super(detailMessage,throwable);
	}
	
	public DefaultDirNotDeclareException(Throwable throwable) {
		super(throwable);
	}
}
