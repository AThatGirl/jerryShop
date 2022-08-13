package com.cj.jerryShop.interceptor;

import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 检查token拦截器
 *
 * @author 杰瑞
 * @date 2022/08/12
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        String method = request.getMethod();
        if ("OPTIONS".equals(method)){
            return true;
        }
        if (token == null){
            ResultVO resultVO=new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE,"请先登录",null);
            doResponse(response,resultVO);
        }else {
            try {
                JwtParser parser= Jwts.parser();
                //解析token的SigningKey必须和生成token时设置的密码一致
                parser.setSigningKey("jerry273k");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            }catch (Exception e){
                ResultVO resultVO=new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE,"请先登录",null);
                doResponse(response,resultVO);
            }

        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
        //设置响应数据格式和编码
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //转成json格式
        String s = new ObjectMapper().writeValueAsString(resultVO);
        //写回数据
        PrintWriter writer = response.getWriter();
        writer.print(s);
        writer.flush();
        writer.close();
    }
}
