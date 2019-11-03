package o2o.dao;

import dao.ProductDao;
import entity.Product;
import entity.ProductCategory;
import entity.Shop;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao dao;

    @Test
    public void insertProductTest(){

        Product product=new Product();
        Shop shop=new Shop();
        shop.setShopId(68L);
        product.setShop(shop);
        product.setPriority(2);
        product.setProductName("wqwe");
        ProductCategory productCategory=new ProductCategory();
        productCategory.setProductCategoryId(1L);
        productCategory.setShopId(68L);
        product.setProductCategory(productCategory);
        product.setEnableStatus(0);
        dao.insertProduct(product);
    }

    @Test
    public void queryProductByIdTest(){

        Product product=dao.queryProductById(44L);
        System.out.println(product==null);
        System.out.println(product.getImgAddr()+" ");
    }

    @Test
    public void updateProductTest(){

        Product product=dao.queryProductById(44L);
        product.setProductName("444");
        dao.updateProduct(product);
    }

    @Test
    public void queryProductListTest(){
        Product productCondition=new Product();
        productCondition.setProductName("d");
        List<Product> list=dao.queryProductList(productCondition,0,1);
        for(Product product:list){
            System.out.println(product.getProductName());
            System.out.println(product.getProductCategory().getProductCategoryName());
        }


    }

}
