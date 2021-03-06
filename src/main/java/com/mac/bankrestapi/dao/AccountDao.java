package com.mac.bankrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mac.bankrestapi.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{

}
