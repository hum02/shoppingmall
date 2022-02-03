package com.shoppingmall.domain.item;

import com.shoppingmall.constant.ItemSellStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Item item=Item.builder().itemNm("테스트 상품").itemDetail("테스트 상품의 상세설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100).price(5000).build();
        
        itemRepository.save(item);

    }
}