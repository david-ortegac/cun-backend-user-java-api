package co.edu.cun.backend_java_api.domain;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api.domain.utils.Message;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import co.edu.cun.backend_java_api.infraestructure.repositories.UserRespository;
import co.edu.cun.backend_java_api.infraestructure.storage.StorageImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service

public class UserServiceImp implements UserService {

    @Autowired
    private UserRespository repository;

    @Autowired
    private StorageImp storageImp;

    @Autowired
    private UserDomainMapper mapper;


    @Override
    public List<Users> getAllUsers() {
        return mapper.toEntityList(mapper.toUserDomainDtoList(storageImp.getAllUsers()));
    }

    @Transactional(readOnly = true)
    @Override
    public Users getUserById(Long id) {
        return mapper.toEntity(mapper.toUserDomainDto(storageImp.getUserById(id)));
    }

    @Override
    @Transactional
    public Users saveUser(UserAdapter usersAdapter) {
        return storageImp.saveUser(usersAdapter);
    }

    @Override
    public Users updateUser(UserAdapter usersAdapter, Long id) {
        return storageImp.updateUser(usersAdapter, id);
    }

    @Override
    public UserAdapter deleteUser(Long id) {
        return storageImp.deleteUser(id);
    }
}
