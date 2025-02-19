package co.edu.cun.backend_java_api.adapter.restful.v1.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowNonPortable;

import java.time.LocalDateTime;

@Data
@AllowNonPortable
@NoArgsConstructor
public class UserAdapter {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthdate;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
