package co.edu.cun.backend_java_api.adapter.restful.v1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdapter {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String birthdate;
}
