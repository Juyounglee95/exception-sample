package com.skcc.demo.exceptionsample.context.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.demo.exceptionsample.context.domain.users.model.User;

@RepositoryRestResource
public interface UserRepository extends QuerydslPredicateExecutor<User>, JpaRepository<User, Long> {

}
