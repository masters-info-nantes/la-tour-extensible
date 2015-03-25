package latourextensible.platform.event;

/** Interface that must be implement by all classes wanted to receive {@link latourextensible.platform.event.Event}
 */
public interface IEventListener {
	/** Automatically call when an {@code Event} is sent to this object.
	 * @param event The {@code Event} to receive
	 */
	public void onEvent(Event event);
}
