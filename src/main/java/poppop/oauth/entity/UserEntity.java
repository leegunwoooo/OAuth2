package poppop.oauth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private String nickname;
    private String phone;

    @Builder
    public UserEntity(String username, String password, String role, String nickname, String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nickname = nickname;
        this.phone = phone;
    }
}
