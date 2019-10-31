package service;

import dto.ProductCategoryExecution;
import entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> getProductCategoryByshopId(Long shopId);
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> list);

    public ProductCategoryExecution deleteProductCategory(Long productCategory, Long shopId);

}
