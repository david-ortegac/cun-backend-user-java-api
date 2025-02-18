package co.edu.cun.backend_java_api.application.service;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> getAllUsers();
    public Users getUserById(Long id);
    public Users saveUser(UserAdapter users);
    public Users updateUser(UserAdapter users);
    public void deleteUser(Long id);
}
