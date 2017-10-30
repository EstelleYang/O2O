package com.o2o.Dao;

import com.o2o.BaseTest;
import com.o2o.DO.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    public void queryShopCategoryTest(){
        List<ShopCategory> list = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(18,list.size());
    }

}
