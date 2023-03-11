package fpt.edu.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import fpt.edu.domain.CartItem;
import fpt.edu.service.CartItemService;

@SessionScope
@Service
public class CartItemServiceImpl implements CartItemService {
	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getProductId());
		if (cartItem == null) {
			maps.put(item.getProductId(), item);
		} else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}

	@Override
	public CartItem findCartById(Long id) {
		for (CartItem cartService : maps.values()) {
			if (cartService.getProductId() == id) {
				return cartService;
			}
		}
		return null;
	}

	@Override
	public void remove(Long productId) {
		maps.remove(productId);
	}

	@Override
	public CartItem update(Long productId, int quantity) {
		CartItem cartItem = maps.get(productId);
		cartItem.setQuantity(quantity);
		return cartItem;
	}

	@Override
	public void clear() {
		maps.clear();
	}

	@Override
	public Collection<CartItem> getAllItems() {
		return maps.values();
	}

	@Override
	public int getCount() {
		return maps.values().size();
	}

	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
	}
}
