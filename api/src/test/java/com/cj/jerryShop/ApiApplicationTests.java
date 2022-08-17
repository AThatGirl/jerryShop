package com.cj.jerryShop;

import com.cj.jerryShop.dao.CategoryMapper;
import com.cj.jerryShop.dao.ProductMapper;
import com.cj.jerryShop.entity.CategoryVO;
import com.cj.jerryShop.entity.ProductVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<CategoryVO> categories= categoryMapper.selectAllCategories2(0);
        for (CategoryVO c1 : categories) {
            System.out.println(c1);

            for (CategoryVO c2 : c1.getCategories()) {
                System.out.println("\t"+c2);
                for (CategoryVO c3 : c2.getCategories()) {
                    System.out.println("\t\t"+c3);
                }
            }
        }

    }
    @Test
    void testRecommend(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO productVO : productVOS) {
            System.out.println(productVO);
        }
    }

}
