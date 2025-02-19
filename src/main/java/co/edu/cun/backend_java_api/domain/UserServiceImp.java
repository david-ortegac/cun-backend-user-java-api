package co.edu.cun.backend_java_api.domain;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRespository repository;

    @Autowired
    private UserDomainMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAllUsers() {
        return mapper.toEntityList(mapper.toUserDomainDtoList(repository.findAll()));
    }

    @Transactional(readOnly = true)
    @Override
    public Users getUserById(Long id) {
        log.info("Buscar el id: {}", id.toString());
        Users optionalUsers = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        return mapper.toEntity(mapper.toUserDomainDto(optionalUsers));
    }

    @Override
    @Transactional
    public Users saveUser(UserAdapter usersAdapter) {
        return repository.save(mapper.toEntity(mapper.toUserDomainDtoFromAdapter(usersAdapter)));
    }

    @Override
    public Users updateUser(UserAdapter usersAdapter, Long id) {
        Users saved = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        Users toUpdate = new Users();
        toUpdate.setId(id);
        if(!Objects.equals(saved.getName(), toUpdate.getName())){
            toUpdate.setName(usersAdapter.getName());
        }else{
            toUpdate.setName(saved.getName());
        }
        if(!Objects.equals(saved.getEmail(), toUpdate.getEmail())){
            toUpdate.setEmail(usersAdapter.getEmail());
        }else{
            toUpdate.setEmail(saved.getEmail());
        }
        if (!Objects.equals(saved.getPassword(), toUpdate.getPassword())){
            toUpdate.setPassword(usersAdapter.getPassword());
        }else{
            toUpdate.setPassword(saved.getPassword());
        }
        if(!Objects.equals(saved.getBirthdate(), toUpdate.getBirthdate())){
            toUpdate.setBirthdate(usersAdapter.getBirthdate());
        }else{
            toUpdate.setBirthdate(saved.getBirthdate());
        }

        return repository.save(toUpdate);
    }

    @Override
    public UserAdapter deleteUser(Long id) {
        log.info("Borrar el id: {}", id.toString());
        Users users = repository.findById(id).orElseThrow(() -> new NotFoundUserExeptions(Message.NOT_FOUND_USER, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        repository.deleteById(id);
        return mapper.toUserAdapterFromDomain(mapper.toUserDomainDto(users));
    }
}
