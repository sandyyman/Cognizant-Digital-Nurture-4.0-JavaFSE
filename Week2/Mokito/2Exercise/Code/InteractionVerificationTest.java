package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ExternalApi2 {
    public String getData() {
        return "Real Data";
    }
}

class MyService2 {
    private ExternalApi2 api;

    public MyService2(ExternalApi2 api) {
        this.api = api;
    }

    public void fetchData() {
        api.getData();
    }
}

public class InteractionVerificationTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi2 mockApi = mock(ExternalApi2.class);
        MyService2 service = new MyService2(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        System.out.println("Interaction verified with getData()");
    }
}
