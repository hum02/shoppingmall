package com.shoppingmall.domain.item.Dto;

import com.shoppingmall.domain.item.ItemImg;
import lombok.Getter;
import org.modelmapper.ModelMapper;

@Getter
public class ItemImgDto {

    private static ModelMapper modelMapper= new ModelMapper();

    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repimgYn;


    public static ItemImgDto of(ItemImg itemImg){
        return modelMapper.map(itemImg,ItemImgDto.class);
    }
}
