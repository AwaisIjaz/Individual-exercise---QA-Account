package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.model.QAAccount;

public interface QAAccountRepository extends JpaRepository<QAAccount, Long> {

}
