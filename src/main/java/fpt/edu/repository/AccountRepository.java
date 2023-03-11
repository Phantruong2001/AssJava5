package fpt.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.domain.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	

}
