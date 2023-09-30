package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.CartResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Cart;
import com.TreueTechnologies.OnineBookStore.Entity.Item;
import com.TreueTechnologies.OnineBookStore.Entity.User;
import com.TreueTechnologies.OnineBookStore.Repository.CartRepository;
import com.TreueTechnologies.OnineBookStore.Repository.UserRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;
    @Override
    public CartResponseDto addToCart(int userId, Item item) {

        User user=userRepository.findById(userId).get();
        Cart cart=user.getCart();
        int totalCost=cart.getTotalCost()+(item.getRequiredQuantity()*item.getBook().getPrice());

        int newItemTotal=item.getRequiredQuantity()+cart.getNumberOfItem();

        cart.setTotalCost(totalCost);

        cart.getItemList().add(item);

        cart.setNumberOfItem(newItemTotal);

        Cart savedCart=cartRepository.save(cart);

        CartResponseDto cartResponseDto=new CartResponseDto();
        CartResponseDto.builder().TotalCost(savedCart.getTotalCost()).totalNoOfItem(savedCart.getNumberOfItem())
                .itemList(savedCart.getItemList()).userName(cart.getUser().getName()).build();

        return cartResponseDto;
    }
}
