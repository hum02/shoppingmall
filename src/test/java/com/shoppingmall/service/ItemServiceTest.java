package com.shoppingmall.service;


import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.domain.item.Dto.ItemFormDto;
import com.shoppingmall.domain.item.Item;
import com.shoppingmall.domain.item.ItemImg;
import com.shoppingmall.repository.ItemImgRepository;
import com.shoppingmall.repository.ItemRepository;
import com.shoppingmall.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemImgRepository itemImgRepository;

    List<MultipartFile> createMultipartFiles() throws Exception {

        List<MultipartFile> multipartFileList = new ArrayList<>();

        for(int i=0;i<5;i++){
            String path = "/Users/20180267/item";
            String imageName = "image" + i + ".jpg";
            MockMultipartFile multipartFile = new MockMultipartFile(path, imageName,
                    "image/jpg", new byte[]{1,2,3,4});
            multipartFileList.add(multipartFile);
        }

        return multipartFileList;
    }

    @Test
    @DisplayName("상품 등록 테스트")
    void saveItemImgTest() throws Exception {
        Item item=Item.builder().itemNm("테스트 상품").itemDetail("테스트 상품의 상세설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100).price(5000).build();

        ItemImg itemImg=ItemImg.builder().item(item).repimgYn("Y").build();
        System.out.println(itemImg.toString());

    }


}