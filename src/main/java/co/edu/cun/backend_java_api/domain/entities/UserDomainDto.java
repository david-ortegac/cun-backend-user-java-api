package co.edu.cun.backend_java_api.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllowNonPortable
@NoArgsConstructor
public class UserDomainDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthdate;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
