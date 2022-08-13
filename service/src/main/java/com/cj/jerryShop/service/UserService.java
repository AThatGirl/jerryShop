package com.cj.jerryShop.service;

import com.cj.jerryShop.vo.ResultVO;

/**
 * 用户service
 *
 * @author 杰瑞
 * @date 2022/08/04
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @return {@link ResultVO}
     */
    public ResultVO userRegister(String name,String pwd);


    /**
     * 检查登录
     *
     * @param name 名字
     * @param pwd  松材线虫病
     * @return {@link ResultVO}
     */
    public ResultVO checkLogin(String name, String pwd);

}
