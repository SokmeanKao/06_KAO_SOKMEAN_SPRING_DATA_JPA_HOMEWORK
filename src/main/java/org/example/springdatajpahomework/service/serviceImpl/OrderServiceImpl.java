package org.example.springdatajpahomework.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Order;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.entity.ProductOrder;
import org.example.springdatajpahomework.model.enums.Status;
import org.example.springdatajpahomework.repository.CustomerRepository;
import org.example.springdatajpahomework.repository.OrderRepository;
import org.example.springdatajpahomework.repository.ProductRepository;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

//    @Override
//    public OrderResponse createOrder(Long customerId, List<ProductOrderRequest> productOrderRequests) {
//        System.out.println(customerId);
//        // Retrieve the customer by customerId
//        Customer customer = customerRepository.findById(customerId).orElseThrow(null);
//
//        // Create a new Order entity
//        Order order = new Order();
//        order.setOrderDate(LocalDateTime.now());
//        order.setStatus(Status.PENDING); // Set the appropriate status
//        order.setCustomer(customer);
//
//        // Create a list to hold the ProductOrder entities
//        List<ProductOrder> productOrders = new ArrayList<>();
//
//        // Calculate the total amount
//        float totalAmount = 0;
//
//        // For each ProductOrderRequest, create a ProductOrder entity
//        for (ProductOrderRequest productOrderRequest : productOrderRequests) {
//            // Retrieve the Product entity by productId
//            Product product = productRepository.findById(productOrderRequest.getProductId())
//                    .orElseThrow(() -> new RuntimeException("Product not found"));
//
//            // Create a new ProductOrder entity
//            ProductOrder productOrder = new ProductOrder();
//            productOrder.setProduct(product);
//            productOrder.setOrder(order);
//            productOrder.setQuantity(productOrderRequest.getQuantity());
//
//            // Add the ProductOrder to the list
//            productOrders.add(productOrder);
//
//            // Add the price of the product to the total amount
//            totalAmount += product.getUnitPrice() * productOrderRequest.getQuantity();
//        }
//
//        // Set the total amount on the Order entity
//        order.setTotalAmount(totalAmount);
//
//        // Set the ProductOrder list on the Order entity
//        order.setProductOrderList(productOrders);
//
//        // Save the Order entity using the OrderRepository
//        Order savedOrder = orderRepository.save(order);
//
//        // Convert the saved Order entity to an OrderResponse DTO
//        return savedOrder.toResponse();
//    }

    @Override
    public OrderResponse createOrder(Long customerId, List<OrderRequest> orderRequests) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        List<ProductOrder> productOrders = orderRequests.stream()
                .map(request -> {
                    Product product = productRepository.findById(request.getProductId())
                            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
                    return new ProductOrder(null, product, null, request.getQuantity());
                }).collect(Collectors.toList());

        Float totalAmount = (float) productOrders.stream()
                .mapToDouble(po -> po.getProduct().getUnitPrice() * po.getQuantity())
                .sum();

        Order orders = new Order(null, LocalDateTime.now(), totalAmount, Status.PENDING, productOrders, customer);
        productOrders.forEach(po -> po.setOrder(orders));
        Order savedOrder = orderRepository.save(orders);
        return savedOrder.toResponse();
    }

    @Override
    public List<OrderResponse> getOrderByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Order> orders = customer.getOrder();

        return orders.stream()
                .map(Order::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(null).toResponse();
    }

    @Override
    public OrderResponse updateOrderStatus(Status status, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(null);
        order.setStatus(status);
        return orderRepository.save(order).toResponse();
    }

}
