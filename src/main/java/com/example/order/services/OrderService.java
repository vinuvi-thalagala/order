package com.example.order.services;

import com.example.order.models.Order;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.dto.OrderDTO;
import com.example.order.repo.OrderRepo;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    
    public OrderDTO createOrder(OrderDTO orderDTO) {
         orderRepo.save(modelMapper.map(orderDTO, Order.class));
         return orderDTO;
    }

    public List<OrderDTO> getAllOrders() {
        List<Order>orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }


    public OrderDTO updateOrder(OrderDTO orderDTO) {
        orderRepo.save(modelMapper.map(orderDTO, Order.class));
        return orderDTO;
    }

    public String deleteOrder(Integer orderId){
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer orderId){
        Order order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }

}
