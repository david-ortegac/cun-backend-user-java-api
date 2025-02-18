package co.edu.cun.backend_java_api.adapter.restful.v1.rest;

import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class Restful implements UserService {

    @Override
    @GetMapping("/")
    public List<Users> getAllUsers() {
        //return ResponseEntity.ok(userService.getAllUsers());
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        //return ResponseEntity.ok(userService.getUserById(id));
        return null;
    }

    @Override
    public Users saveUser(Users users) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public Users updateUser(Users users) {
        return null;
    }
}
