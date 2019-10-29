package dao;

import entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {

    public List<ProductCategory> queryProductCategoryListByShopId(
            @Param("shopId") Long shopId);

}
