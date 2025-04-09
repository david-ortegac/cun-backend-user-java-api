package co.edu.cun.backend_java_api_users.adapter.restful.v1.mapper;

import co.edu.cun.backend_java_api_users.adapter.restful.v1.models.UserAdapterDto;
import co.edu.cun.backend_java_api_users.domain.entities.UserDomainDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdapterMapper {



    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "correo", source = "email")
    @Mapping(target = "contrasenia", source = "password")
    @Mapping(target = "cumpleanios", source = "birthdate")
    UserAdapterDto toUserAdapter(UserDomainDto userDomainDto);

    @Mapping(target = "nombre", source = "name")
    @Mapping(target = "correo", source = "email")
    @Mapping(target = "contrasenia", source = "password")
    @Mapping(target = "cumpleanios", source = "birthdate")
    List<UserAdapterDto> toUserAdapterList(List<UserDomainDto> domainDtoList);

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "contrasenia", target = "password")
    @Mapping(source = "cumpleanios", target = "birthdate")
    UserDomainDto toUserDomainDto(UserAdapterDto userAdapterDto);

    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "correo", target = "email")
    @Mapping(source = "contrasenia", target = "password")
    @Mapping(source = "cumpleanios", target = "birthdate")
    List<UserDomainDto> toUserDomainDtoList(List<UserAdapterDto> adapterList);
}
