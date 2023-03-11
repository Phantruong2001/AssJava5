package fpt.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.domain.Customer;
@Repository
public interface CustomerResponsitory extends JpaRepository<Customer, Integer>{
	
}
