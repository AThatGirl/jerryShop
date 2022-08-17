package com.cj.jerryShop.controller;

import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 购物车controller
 *
 * @author 杰瑞
 * @date 2022/08/10
 */


@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@ApiOperation(value = "购物车相关接口",tags = "购物车管理")
public class ShopcartController {


    @RequestMapping("/list")
    public ResultVO listCarts(){
        return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,"登录成功",null);
    }


}
