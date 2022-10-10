package br.eti.gadelha.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRefreshToken extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);
    @Modifying
    int deleteByUser(User user);
}