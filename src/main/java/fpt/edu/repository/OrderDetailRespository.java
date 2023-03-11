package fpt.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fpt.edu.domain.OrderDetail;
@Repository
public interface OrderDetailRespository extends JpaRepository<OrderDetail, Integer>{

}
