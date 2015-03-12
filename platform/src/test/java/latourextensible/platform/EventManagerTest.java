package latourextensible.platform.event;

import java.lang.Thread;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

public class EventManagerTest {

	public static final String ACTION_ONE = "latourextensible.platform.EventManagerTest.ONE";
	public static final String ACTION_TWO = "latourextensible.platform.EventManagerTest.TWO";
	public static final String ACTION_THREE = "latourextensible.platform.EventManagerTest.THREE";

	private EventManager em;
	private Test1 test1;
	private Test2 test2;

	@Before
	public void setUp() {
		em = EventManager.getDefaultInstance();
		test1 = new Test1();
		test1.run();
		test2 = new Test2();
		test2.run();
	}

	@Test
	public void testConstruct() {
		assertNotNull(EventManager.getDefaultInstance());
		assertNotNull(EventManager.getDefaultInstance());
		assertNotNull(EventManager.getDefaultInstance());
	}

	@Test
	public void testSendEvent() {
		em.send(test1,new Event(ACTION_ONE));
		assertTrue(test1.eventOne);
		assertFalse(test1.eventDefault);
		assertFalse(test2.eventOne);
		assertFalse(test2.eventTwo);
		assertFalse(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testSendEventNotRegistered() {
		em.send(test2,new Event(ACTION_THREE));
		assertFalse(test1.eventOne);
		assertFalse(test1.eventDefault);
		assertFalse(test2.eventOne);
		assertFalse(test2.eventTwo);
		assertTrue(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testSendEventNotExpected() {
		em.send(test1,new Event(ACTION_TWO));
		assertFalse(test1.eventOne);
		assertTrue(test1.eventDefault);
		assertFalse(test2.eventOne);
		assertFalse(test2.eventTwo);
		assertFalse(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testBroadcastEventExpectedByAll() {
		em.broadcast(new Event(ACTION_ONE));
		assertTrue(test1.eventOne);
		assertFalse(test1.eventDefault);
		assertTrue(test2.eventOne);
		assertFalse(test2.eventTwo);
		assertFalse(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testBroadcastEventExpectedByOne() {
		em.broadcast(new Event(ACTION_TWO));
		assertFalse(test1.eventOne);
		assertFalse(test1.eventDefault);
		assertFalse(test2.eventOne);
		assertTrue(test2.eventTwo);
		assertFalse(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testBroadcastEventNotExpected() {
		em.broadcast(new Event(ACTION_THREE));
		assertFalse(test1.eventOne);
		assertFalse(test1.eventDefault);
		assertFalse(test2.eventOne);
		assertFalse(test2.eventTwo);
		assertFalse(test2.eventThree);
		assertFalse(test2.eventDefault);
	}

	@Test
	public void testToString() {
		assertNotNull(em.toString());
	}

	private class Test1 extends Thread implements IEventListener {

		public boolean eventOne = false;
		public boolean eventDefault = false;

		public Test1() {
			em.register(ACTION_ONE,this);
		}

		public void run() {
			System.out.println("Test1.run");
		}
		
		public void onEvent(Event event) {
			switch(event.getAction()) {
			case ACTION_ONE:
				eventOne = true;
				break;
			default:
				eventDefault = true;
			}
		}
	}

	private class Test2 extends Thread implements IEventListener {

		public boolean eventOne = false;
		public boolean eventTwo = false;
		public boolean eventThree = false;
		public boolean eventDefault = false;

		public Test2() {
			em.register(ACTION_ONE,this);
			em.register(ACTION_TWO,this);
		}

		public void run() {
			System.out.println("Test2.run");
		}

		public void onEvent(Event event) {
			switch(event.getAction()) {
			case ACTION_ONE:
				eventOne = true;
				break;
			case ACTION_TWO:
				eventTwo = true;
				break;
			case ACTION_THREE:
				eventThree = true;
				break;
			default:
				eventDefault = true;
			}
		}
	}
}
