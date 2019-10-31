package service.impl;

import dao.ProductCategoryDao;
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
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }

            }


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("内部错误");
        }


    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(Long productCategory, Long shopId) {

        try{
            if(productCategory==null || shopId==null){
                return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
            }

            int n=productCategoryDao.deleteProductCategory(productCategory,shopId);

            if(n<=0){
                return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
            }else{
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
