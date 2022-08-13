package com.cj.jerryShop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*swagger会帮助我们生成接口文档
      1:配置生成的文档信息
      2:配置生成规则*/
    /*封装接口文档信息*/
    @Bean
    public Docket getDocket(){
        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder=new ApiInfoBuilder();
        //指定生成的文档中的封面信息:文档标题、版本、作者
        apiInfoBuilder.title("《杰瑞商城》后端接口说明")
                .description("此文档详细说明了杰瑞商城后端接口规范")
                .version("v 1.0.0")
                .contact(new Contact("tom","www.tom.com","tom@qq.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();

        //指定文档风格
        Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                        .select().apis(RequestHandlerSelectors.basePackage("com.cj.jerryShop.controller"))
                        .paths(PathSelectors.any()).build();
        return docket;
    }
}
