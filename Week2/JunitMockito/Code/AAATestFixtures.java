import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AAATestFixtures {

    private int a, b;

    @BeforeEach
    public void setup() {
        a = 5;
        b = 3;
        System.out.println("Setup complete");
    }

    @AfterEach
    public void teardown() {
        System.out.println("Teardown complete");
    }

    @Test
    public void testSubtraction() {
        // Arrange done in setup
        // Act
        int result = a - b;
        // Assert
        assertEquals(2, result);
    }
}
