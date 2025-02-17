package co.edu.cun.backend_java_api.domain;

import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import co.edu.cun.backend_java_api.infraestructure.repositories.UserRespository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRespository repository;

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Users> getUserById(Long id) {
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
