package com.network.mylittletale.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com/network/mylittletale"}, annotationClass = org.apache.ibatis.annotations.Mapper.class)
public class MybatisConfig {
}
