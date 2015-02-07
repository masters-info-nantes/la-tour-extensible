package latourextensible.platform;

import static org.junit.Assert.*;
import org.junit.Test;

//~ import java.io.IOException;
import org.junit.Before;

public class EventTest {

	private static final double DELTA = 1e-15;
	Event e;

	@Before
	public void setUp() {
		e = new Event("latourextensible.platform.Event.ACTION_TEST1");
	}

	@Test
	public void testGetSetAction() {
		String beforeAction = e.getAction();
		String actionName = "latourextensible.platform.Event.ACTION_TEST2";
		e.setAction(actionName);
		assertEquals(actionName,e.getAction());
	}

	@Test
	public void testExtra() {
		assertTrue(e.emptyExtra());
		String extraKey1 = "latourextensible.platform.Event.EXTRA_TEST1";
		String extraValue1 = "test1";
		String extraKey2 = "latourextensible.platform.Event.EXTRA_TEST2";
		String extraValue2 = "test2";
		e.addExtra(extraKey1,extraValue1);
		assertFalse(e.emptyExtra());
		assertNotNull(e.getExtra(extraKey1));
		assertEquals(extraValue1,e.getExtra(extraKey1));
		assertNull(e.getExtra(extraKey2));
	}

	@Test
	public void testExtraInt() {
		assertTrue(e.emptyExtra());
		String extraKey1 = "latourextensible.platform.Event.EXTRA_TEST1";
		int extraValue1 = 1;
		String extraKey2 = "latourextensible.platform.Event.EXTRA_TEST2";
		int extraValue2 = 2;
		e.addExtraInt(extraKey1,extraValue1);
		assertFalse(e.emptyExtra());
		assertEquals(extraValue1,e.getExtraInt(extraKey1,-1));
		assertEquals(-1,e.getExtraInt(extraKey2,-1));
		assertNull(e.getExtra(extraKey2));
	}

	@Test
	public void testExtraFloat() {
		assertTrue(e.emptyExtra());
		String extraKey1 = "latourextensible.platform.Event.EXTRA_TEST1";
		float extraValue1 = 1.1f;
		String extraKey2 = "latourextensible.platform.Event.EXTRA_TEST2";
		float extraValue2 = 2.2f;
		e.addExtraFloat(extraKey1,extraValue1);
		assertFalse(e.emptyExtra());
		assertEquals(extraValue1,e.getExtraFloat(extraKey1,-1.0f),DELTA);
		assertEquals(-1.0f,e.getExtraFloat(extraKey2,-1.0f),DELTA);
		assertNull(e.getExtra(extraKey2));
	}

	@Test
	public void testExtraBoolean() {
		assertTrue(e.emptyExtra());
		String extraKey1 = "latourextensible.platform.Event.EXTRA_TEST1";
		boolean extraValue1 = true;
		String extraKey2 = "latourextensible.platform.Event.EXTRA_TEST2";
		boolean extraValue2 = false;
		e.addExtraBoolean(extraKey1,extraValue1);
		assertFalse(e.emptyExtra());
		assertEquals(extraValue1,e.getExtraBoolean(extraKey1));
		assertEquals(false,e.getExtraBoolean(extraKey2));
		assertNull(e.getExtra(extraKey2));
	}

	@Test
	public void testToString() {
		assertNotNull(e.toString());
	}
}
