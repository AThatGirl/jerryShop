package com.cj.jerryShop.dao;

import com.cj.jerryShop.entity.Product;
import com.cj.jerryShop.entity.ProductVO;
import com.cj.jerryShop.general.GeneratorDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneratorDAO<Product> {

    public List<ProductVO> selectRecommendProducts();


}