package co.nttdata.prueba;

import co.nttdata.prueba.controller.ClientController;
import co.nttdata.prueba.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PruebaApplicationTest {
    private ClientController clientController;
    private ClientService clientService;
    @BeforeEach
    void setUp() {
        clientService = mock(ClientService.class);
        clientController = new ClientController(clientService);
    }
    @Test
    void testGetClientByDocument_InternalServerError() {
        when(clientService.getClientByDocument("P", "23445322"))
                .thenThrow(new RuntimeException("Algo salió mal en el servicio"));
        ResponseEntity<String> response = (ResponseEntity<String>) clientController.getClientByDocument("P", "23445322");
        assertEquals(500, response.getStatusCodeValue());
    }
}

