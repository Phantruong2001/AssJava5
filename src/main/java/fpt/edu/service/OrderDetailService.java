package fpt.edu.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import fpt.edu.domain.OrderDetail;

public interface OrderDetailService {

	<S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends OrderDetail> List<S> findAll(Example<S> example);

	void deleteAll();

	OrderDetail getReferenceById(Integer id);

	void deleteAll(Iterable<? extends OrderDetail> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	OrderDetail getById(Integer id);

	void delete(OrderDetail entity);

	OrderDetail getOne(Integer id);

	void deleteById(Integer id);

	void deleteAllInBatch();

	long count();

	<S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends OrderDetail> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<OrderDetail> entities);

	<S extends OrderDetail> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<OrderDetail> entities);

	Optional<OrderDetail> findById(Integer id);

	<S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends OrderDetail> S saveAndFlush(S entity);

	void flush();

	List<OrderDetail> findAllById(Iterable<Integer> ids);

	List<OrderDetail> findAll(Sort sort);

	Page<OrderDetail> findAll(Pageable pageable);

	List<OrderDetail> findAll();

	<S extends OrderDetail> Optional<S> findOne(Example<S> example);

	<S extends OrderDetail> S save(S entity);

}
