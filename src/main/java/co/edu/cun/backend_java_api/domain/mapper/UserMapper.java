package co.edu.cun.backend_java_api.domain.mapper;

import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    Users toUserDomainDto(Users users);
    UserDomainDto toEntity(UserDomainDto userDomainDto);
}
