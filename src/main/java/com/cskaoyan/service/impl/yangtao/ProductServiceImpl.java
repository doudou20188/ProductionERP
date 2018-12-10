package com.cskaoyan.service.impl.yangtao;

import com.cskaoyan.domain.yangtao.Product;
import com.cskaoyan.mapper.yangtao.ProductMapper;
import com.cskaoyan.service.yangtao.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/8 0008
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;


    @Override
    public List<Product> findAllProducts() {
        List<Product> productList=productMapper.findAllProductsFromDB();
        return productList;
    }

    @Override
    public Product findProductById(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public boolean addProduct(Product product) {
        boolean b =false;
        int i = productMapper.insertSelective(product);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean b = false;
        int i = productMapper.updateByPrimaryKeySelective(product);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public boolean deleteProducts(String id) {
        boolean b =false;
        int i = productMapper.deleteByPrimaryKey(id);
        if (i==1){
            b=true;
        }
        return b;
    }

    @Override
    public Product findProductByName(String searchValue) {
        Product product=productMapper.findProductByNameFromDB(searchValue);
        return product;
    }

    @Override
    public List<Product> findProductListByName(String searchValue) {
        List<Product> productList=productMapper.findProductListByNameFromDB(searchValue);
        return productList;
    }

    @Override
    public List<Product> findProductListByType(String searchValue) {
        List<Product> productList=productMapper.findProductListByTypeFromDB(searchValue);
        return productList;
    }
}
