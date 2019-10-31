package o2o.dao;

import dao.ProductCategoryDao;
import entity.ProductCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProcductCategoryDao extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void queryProductCategoryListByShopIdTest(){
        List<ProductCategory> list=productCategoryDao.queryProductCategoryListByShopId(68L);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getProductCategoryName());
        }

    }

    @Test
    public void batchInsertProductCategoryTest(){
        List<ProductCategory> list=new ArrayList<ProductCategory>();

        ProductCategory pc=new ProductCategory();
        pc.setProductCategoryName("test22");
        pc.setPriority(2);
        pc.setCreateTime(new Date());
        pc.setShopId(68L);

        ProductCategory pc2=new ProductCategory();
        pc2.setProductCategoryName("test");
        pc2.setPriority(3);
        pc2.setCreateTime(new Date());
        pc2.setShopId(68L);

        list.add(pc);
        list.add(pc2);

        productCategoryDao.batchInsertProductCategory(list);

    }


    @Test
    public void deleteProductCategoryTest(){

        int n=productCategoryDao.deleteProductCategory(37L,68L);
        System.out.println(n);
        assertEquals(1,n);

    }

}
