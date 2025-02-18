package co.edu.cun.backend_java_api.adapter.restful.v1.mapper;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterMapper {
    UserAdapter toUserAdapter(UserDomainDto userDomainDto);
    UserDomainDto toUserDomainDto(UserAdapter userAdapter);
}
