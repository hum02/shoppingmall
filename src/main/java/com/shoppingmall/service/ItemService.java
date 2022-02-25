package com.shoppingmall.service;

import com.shoppingmall.domain.item.Dto.ItemFormDto;
import com.shoppingmall.domain.item.Item;
import com.shoppingmall.domain.item.ItemImg;
import com.shoppingmall.repository.ItemImgRepository;
import com.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception {

        // 상품 등록 (1번)
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // 이미지 등록(2번, 순서중요)
        for (int i = 0; i < itemImgFileList.size(); i++) {
            System.out.println("image func");
            ItemImg itemimg;
            if (i == 0) {
                itemimg=ItemImg.builder().item(item).repimgYn("Y").build();
            } else{
                itemimg=ItemImg.builder().item(item).repimgYn("N").build();
            }

            itemImgService.saveItemImg(itemimg, itemImgFileList.get(i));
        }
        return item.getId();
    }
}
