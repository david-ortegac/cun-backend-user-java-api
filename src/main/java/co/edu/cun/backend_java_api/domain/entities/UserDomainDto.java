package co.edu.cun.backend_java_api.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.Date;

@Data
@AllowNonPortable
@NoArgsConstructor
public class UserDomainDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String birthdate;
    private Date createAt;
    private Date updateAt;
}
