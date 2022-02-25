package com.shoppingmall.domain.item.Dto;

import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemFormDtoTest {

    @Test
    @DisplayName("model mapper 테스트 dto->entitiy")
    void createItemTest() {
        ItemFormDto itemFormDto= ItemFormDto.builder().itemNm("test dto").itemSellStatus(ItemSellStatus.SELL).itemDetail("테스트 상세설명")
                .price(2000).stockNumber(11).build();

        System.out.println("test\n"+itemFormDto.getItemNm());
        System.out.println("test\n"+itemFormDto.createItem().getItemDetail());

    }
}