package o2o.dao;

import dao.ShopDao;
import entity.Area;
import entity.PersonInfo;
import entity.Shop;
import entity.ShopCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void insertShopTest(){
        Shop shop=new Shop();
        Area area=new Area();
        PersonInfo personInfo=new PersonInfo();
        area.setAreaId(1);
        personInfo.setPersonId(9L);
        shop.setShopId(1L);
        shop.setArea(area);
        shop.setOwner(personInfo);
        shop.setShopName("香");
        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setShopCategoryId(1L);
//        shop.setShopCategory(shopCategory);
        shop.setEnableStatus(0);
        int n=shopDao.insertShop(shop);
        assertEquals(1,n);
    }

    @Test
    public void updateShopTest(){
        Shop shop=new Shop();
        shop.setShopId(36L);
        shop.setShopName("牛逼疯了");
        int n=shopDao.updateShop(shop);
        assertEquals(1,n);
    }

    @Test
    public void queryShopByIdTest(){
        Shop shop=shopDao.queryShopById(56L);
        System.out.println(shop.getShopId());
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getShopCategory().getShopCategoryName());
//        System.out.println(shop.getOwner().getName());

        assertEquals(2,shop.getArea().getAreaId().longValue());
    }

    @Test
    public void queryShopsTest(){
        List<Shop> shops=shopDao.queryShops();
        System.out.println(shops.size());
        System.out.println(shops.get(0).getArea().getAreaName());
        for(int i=0;i<shops.size();i++){
            System.out.println(shops.get(i).getShopId());
        }

    }

    @Test
    public void queryShopListTest(){
        Shop shop=new Shop();
        Area area=new Area();
        shop.setShopName("e");
//        area.setAreaId(1);
//        shop.setArea(area);
        List<Shop> list=shopDao.queryShopList(shop,0,4);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getShopId()+" "+list.get(i).getShopName()+" "+
                    list.get(i).getArea().getAreaName()+" "+list.get(i).getShopCategory().getShopCategoryName()+" "+
                    list.get(i).getOwner().getName());
        }
    }

    @Test
    public void queryShopCountTest(){
        Shop shop=new Shop();
        Area area=new Area();
//        shop.setShopName("e");
        int count=shopDao.queryShopCount(shop);
        System.out.println(count);
    }


}
