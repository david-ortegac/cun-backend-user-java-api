package co.edu.cun.backend_java_api.application.service;

import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;

import java.util.List;

public interface UserService {
    List<UserDomainDto> getAllUsers();

    UserDomainDto getUserById(Long id);

    UserDomainDto saveUser(UserDomainDto usersAdapter);

    UserDomainDto updateUser(UserDomainDto usersAdapter, Long id);

    UserDomainDto deleteUser(Long id);
}
