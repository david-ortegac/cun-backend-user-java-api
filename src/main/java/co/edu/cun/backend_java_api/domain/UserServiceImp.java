package co.edu.cun.backend_java_api.domain;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api.domain.utils.Message;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import co.edu.cun.backend_java_api.infraestructure.repositories.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public List<Users> getAllUsers() {
        return mapper.toEntityList(mapper.toUserDomainDtoList(repository.findAll()));
    }

    @Override
    public Users getUserById(Long id) {
        log.info("Buscar el id: {}", id.toString());
        Users optionalUsers = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        return mapper.toEntity(mapper.toUserDomainDto(optionalUsers));
    }

    @Override
    public Users saveUser(UserAdapter users) {
        return null;
    }

    @Override
    public Users updateUser(UserAdapter users) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
