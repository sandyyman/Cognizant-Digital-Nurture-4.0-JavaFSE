import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testStrings() {
        String greeting = "Hello";
        assertEquals("Hello", greeting);
        assertNotNull(greeting);
    }

    @Test
    public void testNumbers() {
        int value = 10;
        assertTrue(value > 5);
        assertFalse(value < 5);
    }

    @Test
    public void testArrayEquality() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }
}
