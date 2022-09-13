package com.cj.jerryShop.dao;

import com.cj.jerryShop.entity.Product;
import com.cj.jerryShop.entity.ProductVO;
import com.cj.jerryShop.general.GeneratorDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneratorDAO<Product> {

    public List<ProductVO> selectRecommendProducts();

    /**
     * 查询指定一级类别下销量最高的6个商品
     *
     * @param cid cid
     * @return {@link List}<{@link ProductVO}>
     */
    public List<ProductVO> selectTop6ByCategory(int cid);

}