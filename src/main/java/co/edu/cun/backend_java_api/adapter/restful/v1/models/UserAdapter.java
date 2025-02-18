package co.edu.cun.backend_java_api.adapter.restful.v1.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowNonPortable;

@Data
@AllowNonPortable
@NoArgsConstructor
public class UserAdapter {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String birthdate;
    private String createAt;
    private String updateAt;
}
