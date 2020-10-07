package com.programflow.programflow.repository;

import com.programflow.programflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
