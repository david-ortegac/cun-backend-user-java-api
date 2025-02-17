package co.edu.cun.backend_java_api.infraestructure.repositories;

import co.edu.cun.backend_java_api.infraestructure.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<Users, Long> {
}
