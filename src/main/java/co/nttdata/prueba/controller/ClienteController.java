package co.nttdata.prueba.controller;
import co.nttdata.prueba.exception.ClienteNotFoundException;
import co.nttdata.prueba.model.ClienteInfo;
import co.nttdata.prueba.services.ClienteService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{tipo}/{numeroDocumento}")
    public ResponseEntity<ClienteInfo> consultarCliente(
            @PathVariable String tipo,
            @PathVariable String numeroDocumento) {

        logger.info("Consultando cliente con tipo {} y número de documento", tipo, numeroDocumento);

        try {
            // Validación inicial de los parámetros (puedes agregar más validaciones según sea necesario)

            if ("C".equals(tipo) || "P".equals(tipo)) {
                ClienteInfo cliente = clienteService.obtenerClienteInfo(tipo, numeroDocumento);

                // Devolver una respuesta con código 200 (OK) y la información del cliente
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            } else {
                // Devolver una respuesta con código 400 (Bad Request) si los parámetros no son válidos
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (ClienteNotFoundException e) {
            // Capturar excepción y devolver una respuesta con código 404 (Not Found) si el cliente no se encuentra
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            // Capturar excepción no controlada y devolver una respuesta con código 500 (Internal Server Error)
            logger.error("Error inesperado al consultar cliente: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
