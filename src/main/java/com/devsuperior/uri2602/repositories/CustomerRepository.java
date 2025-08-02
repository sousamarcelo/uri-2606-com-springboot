package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(nativeQuery = true, value = "SELECT name "
			+ "FROM customers "
			+ "WHERE UPPER(state) = UPPER(:state)") //[state] --> recebido pelo argumento do metodo. utilizado Uppercase na consulta 
	List<CustomerMinProjection> serch1(String state);

}
