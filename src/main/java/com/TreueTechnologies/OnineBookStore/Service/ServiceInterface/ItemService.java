package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.ItemRequestDto;
import com.TreueTechnologies.OnineBookStore.Entity.Item;

public interface ItemService {

    public Item addItem(ItemRequestDto itemRequestDto) throws Exception;
}
