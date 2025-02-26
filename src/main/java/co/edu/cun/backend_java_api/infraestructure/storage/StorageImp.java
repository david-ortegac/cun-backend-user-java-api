package co.edu.cun.backend_java_api.infraestructure.storage;

import co.edu.cun.backend_java_api.adapter.restful.v1.models.UserAdapter;
import co.edu.cun.backend_java_api.application.service.UserService;
import co.edu.cun.backend_java_api.domain.exceptions.NotFoundUserExeptions;
import co.edu.cun.backend_java_api.domain.mapper.UserDomainMapper;
import co.edu.cun.backend_java_api.domain.utils.Message;
import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import co.edu.cun.backend_java_api.infraestructure.repositories.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class StorageImp implements UserService {

    @Autowired
    private UserRespository repository;

    @Autowired
    private UserDomainMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Users getUserById(Long id) {
        log.info("Buscar el id: {}", id.toString());
        return repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public Users saveUser(UserAdapter usersAdapter) {
        return repository.save(mapper.toEntity(mapper.toUserDomainDtoFromAdapter(usersAdapter)));
    }

    @Transactional
    @Override
    public Users updateUser(UserAdapter usersAdapter, Long id) {
        Users saved = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        Users toUpdate = new Users();
        toUpdate.setId(id);
        if (!Objects.equals(saved.getName(), usersAdapter.getName())) {
            toUpdate.setName(usersAdapter.getName());
        } else {
            toUpdate.setName(saved.getName());
        }
        if (!Objects.equals(saved.getEmail(), usersAdapter.getEmail())) {
            toUpdate.setEmail(usersAdapter.getEmail());
        } else {
            toUpdate.setEmail(saved.getEmail());
        }
        if (!Objects.equals(saved.getPassword(), usersAdapter.getPassword())) {
            toUpdate.setPassword(usersAdapter.getPassword());
        } else {
            toUpdate.setPassword(saved.getPassword());
        }
        if (!Objects.equals(saved.getBirthdate(), usersAdapter.getBirthdate())) {
            toUpdate.setBirthdate(usersAdapter.getBirthdate());
        } else {
            toUpdate.setBirthdate(saved.getBirthdate());
        }
        return repository.save(toUpdate);
    }

    @Transactional
    @Override
    public UserAdapter deleteUser(Long id) {
        log.info("Borrar el id: {}", id.toString());
        Users users = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        repository.deleteById(id);
        return mapper.toUserAdapterFromDomain(mapper.toUserDomainDto(users));
    }

}
