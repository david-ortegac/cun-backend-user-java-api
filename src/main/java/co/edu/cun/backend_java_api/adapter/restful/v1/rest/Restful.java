package co.edu.cun.backend_java_api.adapter.restful.v1.rest;

import co.edu.cun.backend_java_api.adapter.restful.v1.mapper.AdapterMapper;
import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class Restful {

    private final UserService userService;

    @Autowired
    public Restful(@Qualifier("userServiceImp") UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private AdapterMapper mapper;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody UserAdapter usersAdapter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(usersAdapter));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody UserAdapter usersAdapter, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(usersAdapter, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserAdapter> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
