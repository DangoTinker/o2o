package o2o.service;

import dto.ImageHolder;
import entity.Product;
import entity.Shop;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.ProductService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest extends BaseTest {

    @Autowired
    private ProductService productService;


    @Test
    public void addProductTest() throws FileNotFoundException {
        Product product=new Product();
        File file=new File("C:\\Users\\63296\\Pictures\\t.jpg");
        product.setProductName("qqqqq");
        Shop shop=new Shop();
        shop.setShopId(68L);
        product.setShop(shop);
        product.setPriority(6);
        product.setEnableStatus(0);

        File file2=new File("C:\\Users\\63296\\Pictures\\1.PNG");
        File file3=new File("C:\\Users\\63296\\Pictures\\2.PNG");

        List<ImageHolder> list=new ArrayList<ImageHolder>();
        list.add(new ImageHolder(new FileInputStream(file2),file2.getName()));
        list.add(new ImageHolder(new FileInputStream(file3),file3.getName()));


        productService.addProduct(product,new ImageHolder(new FileInputStream(file),file.getName()),list);


    }


}
