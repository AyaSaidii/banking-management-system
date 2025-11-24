package com.ayasaidi.bank_account_management.application.impl;

import com.ayasaidi.bank_account_management.application.usecases.BlockUserUseCase;
import com.ayasaidi.bank_account_management.domain.model.User;
import com.ayasaidi.bank_account_management.domain.ports.UserRepositoryPort;

public class BlockUserUseCaseImpl implements BlockUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public BlockUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User blockUser(Long userId) {
        User user = userRepositoryPort.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setBlocked(true);
        return userRepositoryPort.save(user);
    }

}
