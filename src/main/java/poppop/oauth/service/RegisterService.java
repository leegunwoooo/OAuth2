package poppop.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poppop.oauth.dto.RegisterDTO;
import poppop.oauth.entity.RegisterEntity;
import poppop.oauth.repository.RegisterRepository;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterEntity register(RegisterDTO dto){

        RegisterEntity entity = RegisterEntity.builder()
                .id(UUID.randomUUID().toString())
                .clientId(UUID.randomUUID().toString())
                .clientIdIssuedAt(Instant.now())
                .clientSecret(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()))
                .clientAuthenticationMethods("client_secret_basic")
                .authorizationGrantTypes("refresh_token,authorization_code")
                .clientName(dto.getClientName())
                .redirectUris(dto.getRedirectUris())
                .postLogoutRedirectUris(dto.getPostLogoutRedirectUris())
                .scopes(dto.getScopes())
                .clientSettings("{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.client.require-proof-key\":false,\"settings.client.require-authorization-consent\":true}")
                .tokenSettings("{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.token.reuse-refresh-tokens\":true,\"settings.token.x509-certificate-bound-access-tokens\":false,\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"],\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.access-token-format\":{\"@class\":\"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat\",\"value\":\"self-contained\"},\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000],\"settings.token.authorization-code-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.device-code-time-to-live\":[\"java.time.Duration\",300.000000000]}")
                .build();

        return registerRepository.save(entity);
    }
}
