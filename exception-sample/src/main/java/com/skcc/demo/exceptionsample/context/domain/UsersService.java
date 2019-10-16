package com.skcc.demo.exceptionsample.context.domain;

import com.skcc.demo.exceptionsample.context.domain.users.model.User;

public interface UsersService {

	public User findUser(Long id);

}
