package poppop.oauth.dto;

import lombok.Getter;
import lombok.Setter;
import poppop.oauth.entity.UserEntity;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private String nickname;
    private String phone;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .phone(phone)
                .role("Role_ADMIN")
                .build();
    }
}
