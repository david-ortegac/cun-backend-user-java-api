package co.edu.cun.backend_java_api.domain.mapper;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {
    
    UserDomainDto toUserDomainDto(Users users);
    List<UserDomainDto> toUserDomainDtoList(List<Users> users);

    Users toEntity(UserDomainDto userDomainDto);
    List<Users> toEntityList(List<UserDomainDto> userDomainDtoList);

    UserDomainDto toUserDomainDtoFromAdapter(UserAdapter userAdapter);
    UserAdapter toUserAdapterFromDomain(UserDomainDto userDomainDto);
}
