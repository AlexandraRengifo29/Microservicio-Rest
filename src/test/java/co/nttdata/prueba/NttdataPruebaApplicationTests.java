package co.nttdata.prueba;

import co.nttdata.prueba.controller.ClienteController;
import co.nttdata.prueba.exception.ClienteNotFoundException;
import co.nttdata.prueba.model.ClienteInfo;
import co.nttdata.prueba.services.ClienteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NttdataPruebaApplicationTests {
    @Mock
    private ClienteService clienteService;

    private ClienteController clienteController;

    @Before
    public void setUp() {
        clienteController = new ClienteController(clienteService);
    }

    @Test
    public void testConsultarClienteExistente() throws ClienteNotFoundException {
        // Configuración de clienteService para devolver un ClienteInfo simulado
        ClienteInfo clienteInfoEsperado = new ClienteInfo("Juan", "Carlos", "Pérez", "Gómez", "3223456789", "Calle 123", "Armenia");
        when(clienteService.obtenerClienteInfo("C", "23445322")).thenReturn(clienteInfoEsperado);

        // este llama al método consultarCliente en el controlador teniendo en cuenta los datos mockeados
        ResponseEntity<ClienteInfo> respuesta = clienteController.consultarCliente("C", "23445322");

        // estee verifica que la respuesta sea un código 200 (OK)
        assertEquals(HttpStatus.OK, respuesta.getStatusCode());

        // verifica que la información del cliente sea la esperada
        assertEquals(clienteInfoEsperado, respuesta.getBody());
    }

    @Test
    public void testConsultarClienteNoExistente() throws ClienteNotFoundException {
        // Configuración de clienteService para enviar una excepción ClienteNotFoundException
        when(clienteService.obtenerClienteInfo("C", "99999999")).thenThrow(new ClienteNotFoundException("Cliente no encontrado"));

        // este llama  al método consultarCliente en el controlador dado el caso de que el cliente no exista
        ResponseEntity<ClienteInfo> respuesta = clienteController.consultarCliente("C", "99999999");

        // este verifica que la respuesta sea un código 404 (Not Found)
        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
    }

    @Test
    public void testConsultarClienteInvalido() {
        // llama al método consultarCliente en el controlador con un tipo de documento no válido
        ResponseEntity<ClienteInfo> respuesta = clienteController.consultarCliente("X", "12345678");

        // esto verifica que la respuesta sea un código 400 (Bad Request)
        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
    }

    public NttdataPruebaApplicationTests() {

    }
}
