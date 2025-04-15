package poppop.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poppop.oauth.entity.UserEntity;
import poppop.oauth.repository.UserEntityRepository;
import poppop.oauth.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(UserDTO userDTO){
        userEntityRepository.save(userDTO.toEntity());
    }
}
