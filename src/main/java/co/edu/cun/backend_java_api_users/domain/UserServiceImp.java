package co.edu.cun.backend_java_api_users.domain;

import co.edu.cun.backend_java_api_users.application.service.UserService;
import co.edu.cun.backend_java_api_users.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api_users.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api_users.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api_users.domain.utils.Message;
import co.edu.cun.backend_java_api_users.infraestructure.crud.UserCrud;
import co.edu.cun.backend_java_api_users.infraestructure.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class UserServiceImp implements UserService {

    @Autowired
    private UserCrud crud;

    @Autowired
    private UserDomainMapper mapper;

    @Override
    public List<UserDomainDto> getAllUsers() {
        return mapper.toUserDomainDtoList(crud.getAllUsers());
    }

    @Override
    public UserDomainDto getUserById(Long id) {
        log.info("Buscar el id: {}", id.toString());
        return mapper.toUserDomainDto(crud.getUserById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND)));
    }

    @Override
    public UserDomainDto saveUser(UserDomainDto userDomainDto) {
        return  mapper.toUserDomainDto(crud.saveUser(mapper.toEntity(userDomainDto)));
    }

    @Override
    public UserDomainDto updateUser(UserDomainDto userDomainDto, Long id) {
        if(crud.getUserById(id).isPresent()) {
            userDomainDto.setId(id);
            return mapper.toUserDomainDto(crud.saveUser(mapper.toEntity(userDomainDto)));
        }else{
            throw new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserDomainDto deleteUser(Long id) {
        log.info("Borrar el id: {}", id.toString());
        Users user = crud.getUserById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        crud.deleteUser(id);
        return mapper.toUserDomainDto(user);
    }
}
