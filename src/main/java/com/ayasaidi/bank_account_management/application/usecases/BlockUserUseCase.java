package com.ayasaidi.bank_account_management.application.usecases;

import com.ayasaidi.bank_account_management.domain.model.User;

public interface BlockUserUseCase {
    User blockUser(Long userId);
}
