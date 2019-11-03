package service;

import dto.ImageHolder;
import dto.ProductExecution;
import entity.Product;

import java.util.List;


public interface ProductService {

    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> imgList);

    public Product getProductById(Long productId);
    public ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> imgHolderList);

    public ProductExecution getProductList(Product productCondition,int rowIndex,int pageSize);
}
