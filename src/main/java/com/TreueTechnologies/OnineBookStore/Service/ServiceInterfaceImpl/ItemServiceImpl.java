package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.ItemRequestDto;
import com.TreueTechnologies.OnineBookStore.Entity.Book;
import com.TreueTechnologies.OnineBookStore.Entity.Item;
import com.TreueTechnologies.OnineBookStore.Entity.User;
import com.TreueTechnologies.OnineBookStore.Enum.Status;
import com.TreueTechnologies.OnineBookStore.Repository.BookRepository;
import com.TreueTechnologies.OnineBookStore.Repository.ItemRepository;
import com.TreueTechnologies.OnineBookStore.Repository.UserRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item addItem(ItemRequestDto itemRequestDto) throws Exception {
        User user;
        user=userRepository.findById(itemRequestDto.getUserId()).get();
        if(user==null){
            throw new Exception("User Does not Exist");
        }

        if(bookRepository.findById(itemRequestDto.getBookId()).get()==null){
            throw new Exception("Book does not exist");
        }

        Book book=bookRepository.findById(itemRequestDto.getBookId()).get();
        if(book.getStatus().equals(Status.NOT_AVAILABLE)){
            throw new Exception("Out of Stock!");
        }
        if(itemRequestDto.getRequiredQuantity()>book.getQuantity()){
            throw new Exception("The required quantity is Not Available");
        }

        Item item=new Item();
        item.setBook(book);
        item.setBookName(book.getBookName());
        item.setRequiredQuantity(itemRequestDto.getRequiredQuantity());
        item.setCart(user.getCart());

        return itemRepository.save(item);
    }
}
