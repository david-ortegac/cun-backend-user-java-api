package co.edu.cun.backend_java_api_users.application.service;

import co.edu.cun.backend_java_api_users.domain.entities.UserDomainDto;

import java.util.List;

public interface UserService {
    List<UserDomainDto> getAllUsers();

    UserDomainDto getUserById(Long id);

    UserDomainDto saveUser(UserDomainDto usersAdapter);

    UserDomainDto updateUser(UserDomainDto usersAdapter, Long id);

    UserDomainDto deleteUser(Long id);
}
