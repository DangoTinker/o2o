package o2o.dao;

import dao.ProductImgDao;
import entity.ProductImg;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private ProductImgDao dao;

    @Test
    public void insertProductImgTest(){

        ProductImg img=new ProductImg();
        img.setImgAddr("ttt");
        img.setPriority(1);
        dao.insertProductImg(img);

    }

    @Test
    public void batchInsertProductImgTest(){

        List<ProductImg> list=new ArrayList<ProductImg>();

        ProductImg img=new ProductImg();
        img.setImgAddr("zxc");
        img.setPriority(1);

        list.add(img);

        img=new ProductImg();
        img.setImgAddr("ccc");
        img.setPriority(1);

        list.add(img);

        dao.batchInsertProductImg(list);

    }
    @Test
    public void deleteProductImgByProductIdTest(){
        dao.deleteProductImgByProductId(48L);

    }



}
