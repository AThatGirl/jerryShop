package com.cj.jerryShop.service.impl;

import com.cj.jerryShop.dao.UsersMapper;
import com.cj.jerryShop.entity.Users;
import com.cj.jerryShop.service.UserService;
import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.utils.MD5Utils;
import com.cj.jerryShop.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户service实现类
 *
 * @author 杰瑞
 * @date 2022/08/04
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 用户注册
     *
     * @return {@link ResultVO}
     */
    @Transactional
    @Override
    public ResultVO userRegister(String name,String pwd) {
        synchronized (this) {
            //根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("username",name);
            List<Users> users = usersMapper.selectByExample(example);
            //没有注册，进行保存操作
            if (users.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("images/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                //UseGeneratedKeys表示使用主键回填，下面返回的user会有主键值
                int ret = usersMapper.insertUseGeneratedKeys(user);
                if (ret > 0) {


                    return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE, "注册成功", user);
                } else {
                    return new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE, "注册失败", null);
                }

            } else {
                return new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE, "用户名已经被注册！", null);
            }
        }
    }


    /**
     * 检查登录
     *
     * @param name 名字
     * @param pwd  松材线虫病
     * @return {@link Users}
     */
    @Override
    public ResultVO checkLogin(String name, String pwd) {
        //根据名字查询
        Example example = new Example(Users.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("username",name);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size()==0){
            return new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE,"登录失败，用户名不存在！",null);
        }else {
            if (users.get(0).getPassword().equals(MD5Utils.md5(pwd))){
                //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
//                String token = Base64Utils.encode(name + 123456);
                //使用jwt规则生成token字符串
                JwtBuilder builder= Jwts.builder();

                Map<String,Object> map=new HashMap<>();

                String token = builder.setSubject(name)//主题，就是token中的数据
                        .setIssuedAt(new Date())//设置token生成的时间
                        .setId(users.get(0).getUserId() + "")//设置用户id为token id
                        .setClaims(map)//map中存放用户的角色，权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))//设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "jerry273k")//设置加密方式和加密密码
                        .compact();

                return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,token,users.get(0));
            }else {
                return new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE,"登录失败，密码错误！",null);
            }
        }

    }
}
