package dev.antozy.repository;

import dev.antozy.entity.Auth;

public interface AuthRepository extends GenericRepository<Auth, Long> {
    Boolean existsByUserNameAndPassword(String username, String password);
}
