package com.TreueTechnologies.OnineBookStore.Controller;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.ItemRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.CartResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Item;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.CartService;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @PostMapping("/addtoCart")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
        try{
            Item savedItem=itemService.addItem(itemRequestDto);
            CartResponseDto cartResponseDto=cartService.addToCart(itemRequestDto.getUserId(),savedItem);
            return new ResponseEntity(cartResponseDto,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }



}
