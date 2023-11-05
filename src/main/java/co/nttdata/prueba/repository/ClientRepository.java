package co.nttdata.prueba.repository;

import co.nttdata.prueba.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    private List<Client> listClients;
    public ClientRepository() {
        listClients = new ArrayList<>();
        buildDefaultData();
    }
    public Optional<Client> getClientByDocument(String documentNumber, String documentType) {
        return listClients.stream().filter(client ->
                client.getDocumentNumber().equalsIgnoreCase(documentNumber) &&
                        client.getDocumentType().equalsIgnoreCase(documentType)
        ).findFirst();
    }


    private void buildDefaultData() {
        listClients.add(new Client("Lady",
                "Valentina",
                "Rengifo",
                "Roman",
                "3014918020",
                "Carrera 9",
                "Armenia",
                "C",
                "23445322"));
    }
}
