package com.nhom18.fashionshop.service;

import com.nhom18.fashionshop.model.CartItem;
import com.nhom18.fashionshop.model.Order;
import com.nhom18.fashionshop.model.OrderDetail;
import com.nhom18.fashionshop.repository.OrderDetailRepository;
import com.nhom18.fashionshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartService cartService;

//    public List<Order> getOrdersByCustomerName(String customerName) {
//        return orderRepository.findByCustomerName(customerName);
//    }

    public Order createOrder(String customerName, String address, String phone, List<CartItem> cartItems) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setAddress(address);
        order.setPhone(phone);
        order = orderRepository.save(order);

        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            // Set price here if needed
            // detail.setPrice(item.getProduct().getPrice());

            orderDetailRepository.save(detail);
        }

        // Optionally clear the cart after order placement
        cartService.clearCart();
        return order;
    }

    // Method to process order directly, useful for handling external callbacks
    public Order processOrder(String customerName, String address, String phone) {
        List<CartItem> cartItems = cartService.getCartItems();
        return createOrder(customerName, address, phone, cartItems);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
