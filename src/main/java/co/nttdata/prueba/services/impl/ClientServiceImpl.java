package co.nttdata.prueba.services.impl;

import co.nttdata.prueba.domain.Client;
import co.nttdata.prueba.exception.ClientException;
import co.nttdata.prueba.mapping.dto.ClientDto;
import co.nttdata.prueba.mapping.mappers.ClientMapper;
import co.nttdata.prueba.repository.ClientRepository;
import co.nttdata.prueba.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static co.nttdata.prueba.domain.constants.ClientConstants.CLIENT_NOT_EXIST;
import static co.nttdata.prueba.domain.constants.ClientConstants.INVALID_DOCUMENT_TYPE;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    ClientMapper mapper = ClientMapper.INSTANCE;
    private final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    /**
     *
     * @param documentType
     * @param documentNumber
     * @return
     */
    public ClientDto getClientByDocument(String documentType, String documentNumber){
        logger.info("Get client with type {} and document number {}", documentType, documentNumber);
        validateDocumentType(documentType);

        return mapper.clientToClientDto(callGetClientByDocument(documentType, documentNumber));
    }

    private void validateDocumentType(String documentType) throws ClientException {
        logger.info("validate document type {}", documentType);
        if (!"C".equals(documentType) && !"P".equals(documentType)) {
            logger.error(INVALID_DOCUMENT_TYPE+" {}", documentType);
            throw new ClientException(HttpStatus.BAD_REQUEST, INVALID_DOCUMENT_TYPE);
        }
    }

    private Client callGetClientByDocument(String documentType, String documentNumber) {
        return clientRepository.getClientByDocument(documentNumber, documentType)
                .orElseThrow(() -> {
                    logger.error(CLIENT_NOT_EXIST+" {}", documentNumber);
                    return new ClientException(HttpStatus.NOT_FOUND, CLIENT_NOT_EXIST);
                });
    }
}
