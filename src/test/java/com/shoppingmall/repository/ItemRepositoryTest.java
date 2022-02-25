package com.shoppingmall.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.domain.item.Item;
import com.shoppingmall.domain.item.QItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @PersistenceContext
    EntityManager em;

    @AfterEach
    public void cleanUp(){
        itemRepository.deleteAll();
    }

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest(){
        Item item=Item.builder().itemNm("테스트 상품").itemDetail("테스트 상품의 상세설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100).price(5000).build();
        assertEquals(itemRepository.save(item).getId(),item.getId());

    }
    @Test
    @DisplayName("querydsl 테스트1")
    public void queryDslTest(){
        Item item=Item.builder().itemNm("테스트 상품").itemDetail("테스트 상품의 상세설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100).price(5000).build();
        itemRepository.save(item);

        JPAQueryFactory queryFactory=new JPAQueryFactory(em);
        QItem qItem=QItem.item;
        JPAQuery<Item> query=queryFactory.selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("테스트 상품 상세 설명1"))
                .orderBy(qItem.price.desc());
        List<Item> itemList=query.fetch();

        for(Item i:itemList){
            System.out.println(i.toString());
        }
    }

}