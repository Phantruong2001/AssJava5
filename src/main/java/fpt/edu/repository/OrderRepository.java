package fpt.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fpt.edu.domain.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	

}
