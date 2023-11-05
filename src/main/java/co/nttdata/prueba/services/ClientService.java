package co.nttdata.prueba.services;

import co.nttdata.prueba.mapping.dto.ClientDto;

public interface ClientService {

    ClientDto getClientByDocument(String tipo, String numeroDocumento);
}
