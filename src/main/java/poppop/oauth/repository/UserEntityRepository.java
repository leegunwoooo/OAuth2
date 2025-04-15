package poppop.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poppop.oauth.entity.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
