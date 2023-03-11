package fpt.edu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import fpt.edu.domain.CartItem;


public interface CartItemService {

	double getAmount();

	int getCount();

	Collection<CartItem> getAllItems();

	void clear();

	CartItem update(Long productId, int quantity);

	void remove(Long productId);

	void add(CartItem item);



	CartItem findCartById(Long id);



	Map<Long, CartItem> maps = new HashMap<>();

	
}
