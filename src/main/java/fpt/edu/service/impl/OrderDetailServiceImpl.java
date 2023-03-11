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

import fpt.edu.domain.OrderDetail;
import fpt.edu.repository.OrderDetailRespository;
import fpt.edu.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailRespository orderDetailRespository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return orderDetailRespository.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return orderDetailRespository.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRespository.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailRespository.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return orderDetailRespository.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Integer> ids) {
		return orderDetailRespository.findAllById(ids);
	}

	@Override
	public void flush() {
		orderDetailRespository.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return orderDetailRespository.saveAndFlush(entity);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailRespository.findAll(example, pageable);
	}

	@Override
	public Optional<OrderDetail> findById(Integer id) {
		return orderDetailRespository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetail> entities) {
		orderDetailRespository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderDetailRespository.existsById(id);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return orderDetailRespository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
		orderDetailRespository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return orderDetailRespository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		orderDetailRespository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderDetailRespository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return orderDetailRespository.count();
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailRespository.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		orderDetailRespository.deleteById(id);
	}

	@Override
	public OrderDetail getOne(Integer id) {
		return orderDetailRespository.getOne(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailRespository.delete(entity);
	}

	@Override
	public OrderDetail getById(Integer id) {
		return orderDetailRespository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderDetailRespository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		orderDetailRespository.deleteAll(entities);
	}

	@Override
	public OrderDetail getReferenceById(Integer id) {
		return orderDetailRespository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		orderDetailRespository.deleteAll();
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return orderDetailRespository.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailRespository.findAll(example, sort);
	}
	
	
}
