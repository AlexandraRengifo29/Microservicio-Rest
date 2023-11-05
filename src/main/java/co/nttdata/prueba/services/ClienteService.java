package co.nttdata.prueba.services;
import co.nttdata.prueba.exception.ClienteNotFoundException;
import co.nttdata.prueba.model.ClienteInfo;
import org.springframework.stereotype.Service;
@Service
public class ClienteService {

    public ClienteInfo obtenerClienteInfo(String tipo, String numeroDocumento) throws ClienteNotFoundException {
        // Validación de datos del cliente

        // verifica que el tipo de documento sea válido (C o P)
        if (!"C".equals(tipo) && !"P".equals(tipo)) {
            throw new ClienteNotFoundException("Tipo de documento no válido");
        }

        // verifica que el número de documento sea válido (23445322)
        if (!"23445322".equals(numeroDocumento)) {
            throw new ClienteNotFoundException("Cliente no encontrado");
        }

        // Si se pasan todas las validaciones, devuelve la información del cliente
        return new ClienteInfo("Lady", "Valentina", "Rengifo", "Roman", "3014918020", " Carrera 9", "Armenia");
    }
}
