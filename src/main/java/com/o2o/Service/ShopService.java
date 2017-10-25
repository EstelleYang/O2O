package com.o2o.Service;

import com.o2o.DO.Shop;
import com.o2o.DTO.ShopExecution;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImg,String filename);
   // ShopExecution updateShop(Shop shop);
}
