package latourextensible.platform;

import java.lang.Exception;
import java.lang.String;
import java.lang.Throwable;

public class PluginAlreadyInstantiateException extends Exception {
	
	public PluginAlreadyInstantiateException() {
		super();
	}
	
	public PluginAlreadyInstantiateException(String detailMessage) {
		super(detailMessage);
	}
	
	public PluginAlreadyInstantiateException(String detailMessage, Throwable throwable) {
		super(detailMessage,throwable);
	}
	
	public PluginAlreadyInstantiateException(Throwable throwable) {
		super(throwable);
	}
}
