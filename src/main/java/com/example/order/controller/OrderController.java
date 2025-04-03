package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.OrderDTO;
import com.example.order.services.OrderService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create-order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/get-Orders")
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/update-order")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }

     @GetMapping("/get/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

}
