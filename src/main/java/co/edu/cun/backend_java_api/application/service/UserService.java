package co.edu.cun.backend_java_api.application.service;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> getAllUsers();
    public Users getUserById(Long id);
    public Users saveUser(UserAdapter usersAdapter);
    public Users updateUser(UserAdapter usersAdapter, Long id);
    public UserAdapter deleteUser(Long id);
}
