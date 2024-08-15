package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderResponse;

public interface OrderService {

    OrderDTO placeOrder(String emailId, Long cartId, String paymentMethod);

    OrderDTO getOrder(String emailId, Long orderId);

    List<OrderDTO> getOrdersByUser(String emailId);

    OrderResponse getAllOrders(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    OrderDTO updateOrder(String emailId, Long orderId, String orderStatus);
}