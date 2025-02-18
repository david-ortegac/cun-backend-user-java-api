package co.edu.cun.backend_java_api.domain;

import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.exceptions.InvalidUserExeptions;
import co.edu.cun.backend_java_api.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api.domain.utils.Message;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import co.edu.cun.backend_java_api.infraestructure.repositories.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRespository repository;

    @Autowired
    private UserDomainMapper mapper;

    @Override
    public List<Users> getAllUsers() {
        return mapper.toEntityList(mapper.toUserDomainDtoList(repository.findAll()));
    }

    @Override
    public Users getUserById(Long id) {
        //return Optional.ofNullable(repository.findById(id)).orElseThrow(()->new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        log.info("kkk");
        return null;
    }

    @Override
    public Users saveUser(Users users) {
        return null;
    }

    @Override
    public Users updateUser(Users users) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
