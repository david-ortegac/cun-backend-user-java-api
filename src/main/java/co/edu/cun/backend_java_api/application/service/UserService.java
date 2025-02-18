package co.edu.cun.backend_java_api.application.service;

import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<Users> getAllUsers();
    public Users getUserById(Long id);
    public Users saveUser(Users users);
    public void deleteUser(Long id);
    public Users updateUser(Users users);
}
