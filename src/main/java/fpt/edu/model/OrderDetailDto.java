package fpt.edu.model;

import javax.persistence.Column;

public class OrderDetailDto {
	private Long orderDetailId;

	private int orderId;

	private int productId;
	
	private int quantity;

	private double unitPrice;
	
}
