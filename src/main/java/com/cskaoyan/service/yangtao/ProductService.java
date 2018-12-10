package com.cskaoyan.service.yangtao;

import com.cskaoyan.domain.yangtao.Product;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/8 0008
 */
public interface ProductService {
    List<Product> findAllProducts();

    Product findProductById(String productId);

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProducts(String id);

    Product findProductByName(String searchValue);

    List<Product> findProductListByName(String searchValue);

    List<Product> findProductListByType(String searchValue);
}
