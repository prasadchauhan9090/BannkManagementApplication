package com.spring.banckapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.banckapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
