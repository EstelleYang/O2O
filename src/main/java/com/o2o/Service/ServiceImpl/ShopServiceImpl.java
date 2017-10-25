package com.o2o.Service.ServiceImpl;

import com.o2o.DO.Shop;
import com.o2o.DTO.ShopExecution;
import com.o2o.Dao.ShopDao;
import com.o2o.Service.ShopService;
import com.o2o.ShopExceptions.ShopOperationException;
import com.o2o.Util.ImgUtil;
import com.o2o.Util.PathUtil;
import com.o2o.enums.ShopStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
    @Override
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String filename) {
        if (shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        //给店铺附初始值
        try{
            shop.setEnableStatus(0);
            shop.setLastEditTime(new Date());
            shop.setCreateTime(new Date());
            int result = shopDao.insertShop(shop);
            if (result<=0){
                throw new ShopOperationException("店铺创建失败");
            }else if (shopImgInputStream!=null){
                try {
                    addShopImg(shop, shopImgInputStream, filename);
                }catch (Exception e){
                    throw new ShopOperationException("addShopImgError："+e.getMessage());
                }
                //更新店铺的图片地址
                result = shopDao.updateShop(shop);
                if (result<=0){
                    throw new ShopOperationException("更新图片地址失败");
                }
            }

        }catch (Exception e){
            throw new ShopOperationException("addshoperror:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String filename) {
        //获取图片相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImgUtil.generateThumbnail(shopImgInputStream,filename,dest);
        shop.setShopImg(shopImgAddr);
    }


}
