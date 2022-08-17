package com.cj.jerryShop.dao;

import com.cj.jerryShop.entity.ProductImg;
import com.cj.jerryShop.general.GeneratorDAO;

import java.util.List;


public interface ProductImgMapper extends GeneratorDAO<ProductImg> {

    public List<ProductImg> selectProductImgByProductId(String productId);

}