package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.OrderRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.OrderResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Book;
import com.TreueTechnologies.OnineBookStore.Entity.Item;
import com.TreueTechnologies.OnineBookStore.Entity.Order;
import com.TreueTechnologies.OnineBookStore.Entity.User;
import com.TreueTechnologies.OnineBookStore.Enum.Status;
import com.TreueTechnologies.OnineBookStore.Repository.BookRepository;
import com.TreueTechnologies.OnineBookStore.Repository.OrderRepository;
import com.TreueTechnologies.OnineBookStore.Repository.UserRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.OrderService;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderResponseDto placeAnOrder(OrderRequestDto orderRequestDto) throws Exception {

        Book book;
        book=bookRepository.findById(orderRequestDto.getBookId()).get();
        if(book==null){
            throw new Exception("Book does not exist");
        }
        User user=userRepository.findById(orderRequestDto.getUserId()).get();
        if(user==null){
            throw new Exception("User not found");
        }

        Item item=new Item();
        item.setBookName(book.getBookName());
        item.setBook(book);
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        List<Item> itemList=new ArrayList<>();
        itemList.add(item);

        if(orderRequestDto.getRequiredQuantity()>book.getQuantity()||book.getStatus().equals(Status.NOT_AVAILABLE)){
            throw new Exception("Required Quantity is not available");
        }

        book.setQuantity(book.getQuantity()-orderRequestDto.getRequiredQuantity());

        Book book1=bookRepository.save(book);
        if(book1.getQuantity()==0){
            book1.setStatus(Status.NOT_AVAILABLE);
            bookRepository.save(book1);
        }

        Order order=new Order();
        order.setOrderNo(String.valueOf(UUID.randomUUID()));
        order.setDate(new Date());
        Order order1=orderRepository.save(order);

        int totalCost=orderRequestDto.getRequiredQuantity()*book.getPrice();
        order.setTotalCost(totalCost);

        OrderResponseDto orderResponseDto = null;
        orderResponseDto.builder().orderDate(new Date()).orderNo(order1.getOrderNo()).items(itemList).totalCost(order1.getTotalCost()).build();

        return orderResponseDto;
    }
}
