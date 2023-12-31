package com.alireza.java_code_challenge.repository;


import com.alireza.java_code_challenge.entity.Token;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @CachePut(value = "cache2", key = "'token_user_' + #id")
    @Query("select t from Token as t where t.user.id=?1 and (t.expired = false or t.revoked = false )")
    List<Token> findAllValidTokensByUser(Long id);

    @CachePut(value = "cache2", key = "'token_' + #token")
    Optional<Token> findByToken(String token);
}
