package co.edu.cun.backend_java_api.adapter.restful.v1.rest;

import co.edu.cun.backend_java_api.adapter.restful.v1.mapper.AdapterMapper;
import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapterDto;
import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.entities.UserDomainDto;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class Restful {

    private final UserService userService;

    private final AdapterMapper mapper;

    public Restful(UserService userService, @Qualifier("adapterMapper") AdapterMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<UserAdapterDto>> getAllUsers() {
        return ResponseEntity.ok(mapper.toUserAdapterList(userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAdapterDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toUserAdapter(userService.getUserById(id)));
    }

    @PostMapping
    public ResponseEntity<UserAdapterDto> saveUser(@RequestBody UserAdapterDto usersAdapter) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toUserAdapter(userService.saveUser(mapper.toUserDomainDto(usersAdapter))));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserAdapterDto> updateUser(@RequestBody UserAdapterDto usersAdapter, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toUserAdapter(userService.updateUser(mapper.toUserDomainDto(usersAdapter), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserAdapterDto> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toUserAdapter(userService.deleteUser(id)));
    }
}
