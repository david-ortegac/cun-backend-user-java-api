package co.edu.cun.backend_java_api_users.infraestructure.crud;

import co.edu.cun.backend_java_api_users.infraestructure.entity.Users;
import co.edu.cun.backend_java_api_users.infraestructure.repositories.UserRespository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserCrud {

    private final UserRespository repository;

    UserCrud(UserRespository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Users> getUserById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Transactional
    public Users updateUser(Users user) {
        return repository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
