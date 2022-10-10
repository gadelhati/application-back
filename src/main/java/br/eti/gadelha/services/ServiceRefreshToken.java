package br.eti.gadelha.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.repository.RepositoryRefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.eti.gadelha.exception.TokenRefreshException;
import br.eti.gadelha.persistence.repository.RepositoryUser;

@Service
public class ServiceRefreshToken {
    @Value("${gadelha.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RepositoryRefreshToken repositoryRefreshToken;

    @Autowired
    private RepositoryUser repositoryUser;

    public Optional<RefreshToken> findByToken(String token) {
        return repositoryRefreshToken.findByToken(token);
    }
    public RefreshToken createRefreshToken(UUID userId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(repositoryUser.findById(userId).orElse(null));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = repositoryRefreshToken.save(refreshToken);
        return refreshToken;
    }
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            repositoryRefreshToken.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(UUID userId) {
        return repositoryRefreshToken.deleteByUser(repositoryUser.findById(userId).orElse(null));
    }
}