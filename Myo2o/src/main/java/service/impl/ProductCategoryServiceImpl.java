package service.impl;

import dao.ProductCategoryDao;
import dao.ProductDao;
import dto.ProductCategoryExecution;
import entity.ProductCategory;
import enums.ProductCategoryStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductCategoryService;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductCategory> getProductCategoryByshopId(Long shopId) {
        return productCategoryDao.queryProductCategoryListByShopId(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> list) {

        try{

            if(list==null||list.size()==0){
                return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
            }
            else{
                int n=productCategoryDao.batchInsertProductCategory(list);

                if(n<=0){
                    throw new RuntimeException("添加失败");
                }
                else{
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS,list);
                }

            }


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("内部错误");
        }


    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(Long productCategoryId, Long shopId) {


        try{
            if(productCategoryId==null || shopId==null){
                return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
            }


            int n=productCategoryDao.deleteProductCategory(productCategoryId,shopId);
            int en=productDao.updateProductCategoryToNull(productCategoryId);
            if(en<=0){
                throw new RuntimeException("商品类别更新失败");
            }
            if(n<=0){
                throw new RuntimeException("商品类别删除失败");
            }else{
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
