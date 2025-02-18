package co.edu.cun.backend_java_api.adapter.restful.v1.mapper;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdapterMapper {
    UserAdapter toUserAdapter(UserDomainDto userDomainDto);
    List<UserAdapter> toUserAdapterList(List<UserDomainDto> domainDtoList);

    UserDomainDto toUserDomainDto(UserAdapter userAdapter);
    List<UserDomainDto> toUserDomainDtoList(List<UserAdapter> adapterList);
}
