package latourextensible.platform.event;

/** Interface that must be implement by all classes wanted to receive {@see latourextensible.platform.Event}
 */
public interface IEventListener {
	public void onEvent(Event event);
}
