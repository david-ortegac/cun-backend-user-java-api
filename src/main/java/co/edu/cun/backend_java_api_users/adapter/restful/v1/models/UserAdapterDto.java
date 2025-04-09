package co.edu.cun.backend_java_api_users.adapter.restful.v1.models;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

import java.time.LocalDateTime;

@Data
@AllowNonPortable
@NoArgsConstructor
public class UserAdapterDto {
    private Long id;
    private String nombre;
    private String correo;
    private String contrasenia;
    private LocalDateTime cumpleanios;
    @Nullable
    private LocalDateTime createAt;
    @Nullable
    private LocalDateTime updateAt;
}
