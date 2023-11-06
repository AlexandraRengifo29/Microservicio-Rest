package co.nttdata.prueba.controller;

import co.nttdata.prueba.exception.ClientException;
import co.nttdata.prueba.mapping.dto.ClientDto;
import co.nttdata.prueba.mapping.dto.ResponseErrorDto;
import co.nttdata.prueba.services.ClientService;
import co.nttdata.prueba.services.impl.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static co.nttdata.prueba.domain.constants.ClientConstants.UNEXPECTED_ERROR_;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clienteService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService) {
    }


    @GetMapping("/get-client-by-document/{documentType}/{documentNumber}")
    public ResponseEntity<?> getClientByDocument(@PathVariable(name = "documentType", required = true)
                                                 String documentType,
                                                 @PathVariable (name = "documentNumber", required = true)
                                                 String documentNumber) {
        try {
            ClientDto clientDto = clienteService.getClientByDocument(documentType, documentNumber);
            return ResponseEntity.status(HttpStatus.OK).body(clientDto);
        } catch (ClientException ex) {
            return ResponseEntity.status(ex.getStatus()).body(new ResponseErrorDto(ex.getMessage()));
        }
        catch (Exception e) {
            logger.error(UNEXPECTED_ERROR_+"{}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
