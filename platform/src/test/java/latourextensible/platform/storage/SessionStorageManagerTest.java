package latourextensible.platform.storage;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class SessionStorageManagerTest {

	private static final double DELTA = 1e-15;
	
	SessionStorageManager mgr;
	
	@Before
	public void setUp() {
		try {
			mgr = SessionStorageManager.getDefaultInstance();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testGetPutObject() {
		String key = "some key obj";
		Object obj = new Object(){};
		assertNull(mgr.get(key));
		assertTrue(mgr.put(key,obj));
		assertEquals(obj,mgr.get(key));
		assertNotEquals(new Object(){},mgr.get(key));
		assertTrue(mgr.remove(key));
		assertFalse(mgr.remove(key));
		assertTrue(mgr.put(key,null));
		assertNull(mgr.get(key));
		assertFalse(mgr.remove(key));
		assertNull(mgr.get(key));
	}
	
	@Test
	public void testGetPutBoolean() {
		String key = "some key bool";
		assertNull(mgr.getBoolean(key));
		assertTrue(mgr.putBoolean(key,new Boolean(true)));
		assertEquals(Boolean.TRUE,mgr.getBoolean(key));
		assertTrue(mgr.putBoolean(key,new Boolean(false)));
		assertEquals(Boolean.FALSE,mgr.getBoolean(key));
		assertTrue(mgr.remove(key));
		assertNull(mgr.getBoolean(key));
	}

	@Test
	public void testGetPutInt() {
		String key = "some key int";
		assertEquals(-1,mgr.getInt(key,-1));
		assertTrue(mgr.putInt(key,66));
		assertEquals(66,mgr.getInt(key,-1));
		assertTrue(mgr.remove(key));
		assertEquals(-1,mgr.getInt(key,-1));
	}

	@Test
	public void testGetPutFloat() {
		String key = "some key float";
		assertEquals(-1.0f,mgr.getFloat(key,-1.0f),DELTA);
		assertTrue(mgr.putFloat(key,66.0f));
		assertEquals(66.0f,mgr.getFloat(key,-1.0f),DELTA);
		assertTrue(mgr.remove(key));
		assertEquals(-1.0f,mgr.getFloat(key,-1.0f),DELTA);
	}

	@Test
	public void testGetPutString() {
		String key = "some key string";
		String str = "some str";
		assertNull(mgr.getString(key));
		assertTrue(mgr.putString(key,str));
		assertEquals(str,mgr.getString(key));
		assertTrue(mgr.remove(key));
		assertNull(mgr.getString(key));
	}

}
