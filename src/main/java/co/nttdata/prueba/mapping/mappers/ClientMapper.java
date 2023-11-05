package co.nttdata.prueba.mapping.mappers;

import co.nttdata.prueba.domain.Client;
import co.nttdata.prueba.mapping.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToClientDto(Client client);
}
