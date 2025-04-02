package co.edu.cun.backend_java_api.domain;

import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api.domain.utils.Message;
import co.edu.cun.backend_java_api.infraestructure.crud.UserCrud;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
class UserServiceImp implements UserService {

    private UserCrud crud;

    private UserDomainMapper mapper;

    public UserServiceImp(UserCrud crud, @Qualifier("userDomainMapper") UserDomainMapper mapper) {
        this. crud    = crud;
        this.mapper = mapper;
    }

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
