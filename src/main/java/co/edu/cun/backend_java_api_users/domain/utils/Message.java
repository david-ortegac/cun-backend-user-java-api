package co.edu.cun.backend_java_api_users.domain.utils;

public record Message() {
    public static final String NOT_FOUND_USER = "User not found";
    public static final String SUCCESSFULLY_REMOVED = "user removed successfully";
    public static final String USERNAME_ALREADY_EXISTS = "there is already a user with this";
    public static final String JWT_EXPIRED = "static token expired";
}
