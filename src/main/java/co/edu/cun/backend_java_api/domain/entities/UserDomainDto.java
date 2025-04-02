package co.edu.cun.backend_java_api.domain.entities;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDomainDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthdate;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime updateAt;
}
