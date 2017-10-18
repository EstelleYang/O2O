package com.o2o.Dao;

import com.o2o.BaseTest;
import com.o2o.DO.AreaDO;
import com.o2o.DO.PersonInfo;
import com.o2o.DO.Shop;
import com.o2o.DO.ShopCategory;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopDaoTest extends BaseTest{
    @Autowired
    private ShopDao shopDao;
    Shop shop = new Shop();
    PersonInfo owner = new PersonInfo();
    ShopCategory shopCategory = new ShopCategory();
    AreaDO areaDO = new AreaDO();
    @Test
    public void insertShopTest(){
        shopCategory.setShopCategoryId(11L);
        owner.setUserId(1L);
        areaDO.setAreaId(2);
        shop.setPhone("17621760869");
        shop.setEnableStatus(1);
        shop.setShopName("HoneyNail");
        shop.setShopAddr("天宝路65号");
        shop.setShopDesc("美甲店");
        shop.setOwner(owner);
        shop.setArea(areaDO);
        shop.setShopCategory(shopCategory);
        int result = shopDao.insertShop(shop);
        assertEquals(1,result);
    }
    @Test
    public void updateShopTest(){
        shop.setShopId(28L);
        areaDO.setAreaId(3);
        shop.setArea(areaDO);
        shop.setShopDesc("性价比高的美甲店");
        int result = shopDao.updateShop(shop);
        assertEquals(1,result);
    }
}
