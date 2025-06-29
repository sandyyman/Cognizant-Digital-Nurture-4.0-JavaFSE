//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;

class ExternalApi {
    public String getData() {
        return "Real Data";
    }
}

class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}

public class MyServiceTest {

    @Test
    public void testExternalApiMocking() {
        // Mock the dependency
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject into service and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
        System.out.println("Mocking test passed: " + result);
    }
}
