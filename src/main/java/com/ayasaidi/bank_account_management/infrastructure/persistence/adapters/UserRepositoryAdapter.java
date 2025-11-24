package com.ayasaidi.bank_account_management.infrastructure.persistence.adapters;

import com.ayasaidi.bank_account_management.application.mapper.UserMapper;
import com.ayasaidi.bank_account_management.domain.model.User;
import com.ayasaidi.bank_account_management.domain.ports.UserRepositoryPort;
import com.ayasaidi.bank_account_management.infrastructure.persistence.entities.UserEntity;
import com.ayasaidi.bank_account_management.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository jpaRepository;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = jpaRepository.save(entity);
        return UserMapper.toDomain(saved);
    }
    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id).map(UserMapper::toDomain);
    }



    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
