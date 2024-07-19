import org.example.service.StringList;
import org.example.service.StringListImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    private StringListImpl stringList;
    @Before
    public void setUp() {
        stringList = new StringListImpl();
    }
    @Test
    void testAdd() {
        stringList.add("1");
        stringList.add("2");
        assertEquals(2, stringList.size());
        assertTrue(stringList.contains("1"));
        assertTrue(stringList.contains("2"));
    }
    @Test
     void testAddAtIndex() {
        stringList.add(1,"1");
        stringList.add(2,"2");
        stringList.add(3, "3");
        assertEquals(3, stringList.size());
        assertEquals("1", stringList.get(0));
        assertEquals("2", stringList.get(1));
        assertEquals("3", stringList.get(2));
    }
    @Test
    void testSet() {
        stringList.add("1");
        stringList.add("2");
        stringList.set(1, "3");
        assertEquals(2, stringList.size());
        assertEquals("1", stringList.get(0));
        assertEquals("3", stringList.get(1));
    }
    @Test
    void testRemoveByItem() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.remove("2");
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("item2"));
        assertEquals("1", stringList.get(0));
        assertEquals("3", stringList.get(1));
    }
    @Test
    void testRemoveByIndex() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.remove(1);
        assertEquals(2, stringList.size());
        assertFalse(stringList.contains("2"));
        assertEquals("1", stringList.get(0));
        assertEquals("3", stringList.get(1));
    }
    @Test
    void testContains() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        assertTrue(stringList.contains("1"));
        assertTrue(stringList.contains("2"));
        assertTrue(stringList.contains("3"));
        assertFalse(stringList.contains("4"));
    }
    @Test
    void testIndexOf() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        assertEquals(0, stringList.indexOf("1"));
        assertEquals(1, stringList.indexOf("2"));
        assertEquals(2, stringList.indexOf("3"));
        assertEquals(-1, stringList.indexOf("4"));
    }
    @Test
    void testLastIndexOf() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("2");
        stringList.add("3");
        assertEquals(0, stringList.lastIndexOf("1"));
        assertEquals(2, stringList.lastIndexOf("2"));
        assertEquals(3, stringList.lastIndexOf("3"));
        assertEquals(-1, stringList.lastIndexOf("4"));
    }
    @Test
    void testGet() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        assertEquals("1", stringList.get(0));
        assertEquals("2", stringList.get(1));
        assertEquals("3", stringList.get(2));
    }
    @Test
    void testEquals() {
        StringList otherList = new StringListImpl();
        otherList.add("1");
        otherList.add("2");
        otherList.add("3");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        assertTrue(stringList.equals(otherList));
    }
    @Test
    void testSize() {
        assertEquals(0, stringList.size());
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        assertEquals(3, stringList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add("1");
        assertFalse(stringList.isEmpty());
    }

    @Test
    void testClear() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.clear();
        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }
    @Test
    void testToArray() {
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        String[] array = stringList.toArray();
        assertEquals(3, array.length);
        assertEquals("1", array[0]);
        assertEquals("2", array[1]);
        assertEquals("3", array[2]);
    }
}
