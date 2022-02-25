package com.shoppingmall.controller;

import com.shoppingmall.domain.item.Dto.ItemFormDto;
import com.shoppingmall.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemControllerTest {
    @Autowired
    ItemService itemService;

    @Test
    @DisplayName("상품 저장 서비스 테스트")
    public void saveItemTest(){



    }

}