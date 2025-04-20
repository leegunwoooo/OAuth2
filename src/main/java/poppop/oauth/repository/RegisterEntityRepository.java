package poppop.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poppop.oauth.entity.RegisterEntity;

import java.util.Optional;

public interface RegisterEntityRepository extends JpaRepository<RegisterEntity, Long> {
    Optional<RegisterEntity> findByClientId(String clientId);
}
