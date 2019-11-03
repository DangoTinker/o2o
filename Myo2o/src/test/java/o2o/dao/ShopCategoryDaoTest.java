package o2o.dao;

import dao.ShopCategoryDao;
import entity.ShopCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;


    @Test
    public void queryShopCategoryTest(){
        List<ShopCategory> list=shopCategoryDao.queryShopCategory(null);
        for(ShopCategory i:list ){
            System.out.println(i.getShopCategoryName());
        }

    }


}
