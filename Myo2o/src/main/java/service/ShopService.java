package service;

import dto.ShopExecution;
import entity.Shop;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface ShopService {


    public ShopExecution addShop(Shop shop, InputStream file,String fileName);

    public Shop getShopById(Long shopId);

    public ShopExecution modifyShop(Shop shop,InputStream file,String fileName);

    public List<Shop> getShops();

    public ShopExecution getShopList(Shop shop,int rowIndex,int pageSize);

}
