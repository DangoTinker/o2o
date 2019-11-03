package dao;

import entity.ProductImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImgDao {


    public int insertProductImg(ProductImg productImg);

    public int batchInsertProductImg(List<ProductImg> list);

    public int deleteProductImgByProductId(Long productId);
    public List<ProductImg> queryProductImgListByProductId(Long productId);
}
