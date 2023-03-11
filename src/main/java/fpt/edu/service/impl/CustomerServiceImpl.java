package fpt.edu.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import fpt.edu.domain.Account;
import fpt.edu.domain.Customer;
import fpt.edu.repository.CustomerResponsitory;
import fpt.edu.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	 private CustomerResponsitory customerResponsitory;

	@Override
	public Customer findByName(String name) {
		List<Customer> list = customerResponsitory.findAll();
		
		for (Customer customer : list) {
			if(name.equals(customer.getName())) {
				return customer;
			}
		}
		return null;
	}
	
	@Override
	public Customer login(String name, String password) {
		Customer optExist = findByName(name);
		System.out.println(optExist);
		
		if(optExist != null && optExist.getPassword().equals(password)) {
			optExist.setPassword("");
			return optExist;
		}
		return null;
	}
	
	@Override
	public <S extends Customer> S save(S entity) {
		return customerResponsitory.save(entity);
	}

	@Override
	public <S extends Customer> Optional<S> findOne(Example<S> example) {
		return customerResponsitory.findOne(example);
	}

	@Override
	public List<Customer> findAll() {
		return customerResponsitory.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerResponsitory.findAll(pageable);
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return customerResponsitory.findAll(sort);
	}

	@Override
	public List<Customer> findAllById(Iterable<Integer> ids) {
		return customerResponsitory.findAllById(ids);
	}

	@Override
	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
		return customerResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		customerResponsitory.flush();
	}

	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		return customerResponsitory.saveAndFlush(entity);
	}

	@Override
	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return customerResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return customerResponsitory.findAll(example, pageable);
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return customerResponsitory.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		customerResponsitory.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return customerResponsitory.existsById(id);
	}

	@Override
	public <S extends Customer> long count(Example<S> example) {
		return customerResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Customer> entities) {
		customerResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Customer> boolean exists(Example<S> example) {
		return customerResponsitory.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		customerResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return customerResponsitory.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return customerResponsitory.count();
	}

	@Override
	public void deleteAllInBatch() {
		customerResponsitory.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		customerResponsitory.deleteById(id);
	}

	@Override
	public Customer getOne(Integer id) {
		return customerResponsitory.getOne(id);
	}

	@Override
	public void delete(Customer entity) {
		customerResponsitory.delete(entity);
	}

	@Override
	public Customer getById(Integer id) {
		return customerResponsitory.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		customerResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Customer> entities) {
		customerResponsitory.deleteAll(entities);
	}

	@Override
	public Customer getReferenceById(Integer id) {
		return customerResponsitory.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		customerResponsitory.deleteAll();
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		return customerResponsitory.findAll(example);
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		return customerResponsitory.findAll(example, sort);
	}
	
	
}
