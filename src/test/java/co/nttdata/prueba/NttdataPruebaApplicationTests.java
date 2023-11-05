package co.nttdata.prueba;

import org.junit.Before;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class NttdataPruebaApplicationTests {
//    @Mock
//    private ClienteServiceImpl clienteService;


    @Before
    public void setUp() {
//        clienteController = new ClientController();
    }


//    @Test
//    public void testGetClientExist(){
////        ClientDto clientDto = clienteService.getClientByDocument("C","123213");
//        ClientDto clienteInfoEsperado = new ClientDto("Juan", "Carlos", "Pérez", "Gómez", "3223456789", "Calle 123", "Armenia");
//        when(clienteService.getClientByDocument("C","123213")).thenReturn(clienteInfoEsperado);
//    }

//
//    @Test
//    public void testConsultarClienteExistente() throws ClientException {
//        // Configuración de clienteService para devolver un ClienteInfo simulado
//        ClientDto clienteInfoEsperado = new ClientDto("Juan", "Carlos", "Pérez", "Gómez", "3223456789", "Calle 123", "Armenia");
//        when(clienteService.getClientByDocument("C", "23445322")).thenReturn(clienteInfoEsperado);
//
//        // este llama al método consultarCliente en el controlador teniendo en cuenta los datos mockeados
//        ResponseEntity<ClientDto> respuesta = clienteController.consultarCliente("C", "23445322");
//
//        // estee verifica que la respuesta sea un código 200 (OK)
//        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
//
//        // verifica que la información del cliente sea la esperada
//        assertEquals(clienteInfoEsperado, respuesta.getBody());
//    }
//
//    @Test
//    public void testConsultarClienteNoExistente() throws ClientException {
//        // Configuración de clienteService para enviar una excepción ClienteNotFoundException
//        when(clienteService.obtenerClienteInfo("C", "99999999")).thenThrow(new ClientException("Cliente no encontrado"));
//
//        // este llama  al método consultarCliente en el controlador dado el caso de que el cliente no exista
//        ResponseEntity<ClienteInfo> respuesta = clienteController.consultarCliente("C", "99999999");
//
//        // este verifica que la respuesta sea un código 404 (Not Found)
//        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
//    }
//
//    @Test
//    public void testConsultarClienteInvalido() {
//        // llama al método consultarCliente en el controlador con un tipo de documento no válido
//        ResponseEntity<ClienteInfo> respuesta = clienteController.consultarCliente("X", "12345678");
//
//        // esto verifica que la respuesta sea un código 400 (Bad Request)
//        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
//    }
//
//    public NttdataPruebaApplicationTests() {
//
//    }
}
