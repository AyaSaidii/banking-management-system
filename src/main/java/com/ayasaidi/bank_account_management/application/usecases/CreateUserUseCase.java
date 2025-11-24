package com.ayasaidi.bank_account_management.application.usecases;

import com.ayasaidi.bank_account_management.application.dto.UserDto;
import com.ayasaidi.bank_account_management.domain.model.User;

public interface CreateUserUseCase {
   // User create(User user);
   // UserDto create(User user);
    UserDto create(User user, String devise);
}
