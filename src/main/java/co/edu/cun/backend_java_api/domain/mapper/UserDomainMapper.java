package co.edu.cun.backend_java_api.domain.mapper;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapterDto;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {
    
    UserDomainDto toUserDomainDto(Users users);
    List<UserDomainDto> toUserDomainDtoList(List<Users> users);

    Users toEntity(UserDomainDto userDomainDto);

    List<Users> toEntityList(List<UserDomainDto> userDomainDtoList);

}
