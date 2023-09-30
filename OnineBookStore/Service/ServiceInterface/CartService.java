package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.CartResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Item;

public interface CartService {

    public CartResponseDto addToCart(int userId, Item item);
}
