package com.cj.jerryShop.controller;


import com.cj.jerryShop.entity.ProductVO;
import com.cj.jerryShop.service.CategoryService;
import com.cj.jerryShop.service.IndexImgService;
import com.cj.jerryShop.service.ProductService;
import com.cj.jerryShop.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(value = "提供首页数据所需的接口",tags = "首页管理")
public class IndexController {

    @Autowired
    private IndexImgService indexImgService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/indeximgs")
    @ApiOperation("轮播图接口")
    public ResultVO queryIndexImgs(){
       return indexImgService.queryIndexImgs();
    }


    @GetMapping("/category-list")
    @ApiOperation("商品分类查询接口")
    public ResultVO listCategory(){
        return categoryService.queryAllCategory();
    }

    @GetMapping("list-recommends")
    @ApiOperation("查询新品推荐商品的接口")
    public ResultVO queryRecommendProducts(){
        return productService.queryRecommendProduct();
    }

    @GetMapping("category-recommends")
    @ApiOperation("查询分类推荐商品的接口")
    public ResultVO queryRecommendProductsByCategory(){
        return categoryService.queryFirstLevelCategories();
    }


}
