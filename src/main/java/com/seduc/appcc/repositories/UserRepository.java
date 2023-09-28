package com.seduc.appcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seduc.appcc.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
