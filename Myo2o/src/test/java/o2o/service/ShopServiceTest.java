package o2o.service;

import dto.ImageHolder;
import dto.ShopExecution;
import entity.Area;
import entity.PersonInfo;
import entity.Shop;
import enums.ShopStateEnum;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.ShopService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void addShopTest() throws FileNotFoundException {
        Shop shop=new Shop();
        Area area=new Area();
        PersonInfo personInfo=new PersonInfo();
        area.setAreaId(2);
        personInfo.setPersonId(9L);
        shop.setArea(area);
        shop.setOwner(personInfo);
        shop.setShopName("zzzzz");
        shop.setEnableStatus(0);

        File file=new File("C:\\Users\\63296\\Pictures\\t.jpg");

        ShopExecution n=shopService.addShop(shop,new ImageHolder(new FileInputStream(file),file.getName()));

        assertEquals(0,n.getState());
    }

    @Test
    public void getShopByIdTest(){
        Shop shop=shopService.getShopById(56L);
        System.out.println(shop.getShopId());
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getShopCategory().getShopCategoryName());
//        System.out.println(shop.getOwner().getName());

        assertEquals(2,shop.getArea().getAreaId().longValue());
    }

    @Test
    public void modifyShopTest() throws FileNotFoundException {
        Shop shop=shopService.getShopById(63L);
        shop.setShopName("nanguangwei");
        File file=new File("C:\\Users\\63296\\Pictures\\t.jpg");
        ShopExecution se=shopService.modifyShop(shop,new ImageHolder(new FileInputStream(file),file.getName()));
        assertEquals(1,se.getState());
    }


    @Test
    public void getShopListTest(){
        Shop shop=new Shop();
//        shop.setShopName("e");
        ShopExecution se=shopService.getShopList(shop,2,2);
        System.out.println(se.getCount());
        List<Shop> list=se.getShops();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getShopId()+" "+list.get(i).getShopName()+" "+
                    list.get(i).getArea().getAreaName()+" "+list.get(i).getShopCategory().getShopCategoryName()+" "+
                    list.get(i).getOwner().getName());
        }

    }

}
