package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.OrderRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.OrderResponseDto;

public interface OrderService {

    public OrderResponseDto placeAnOrder(OrderRequestDto orderRequestDto) throws Exception;


}
