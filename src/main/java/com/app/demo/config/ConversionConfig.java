package com.app.demo.config;


import com.app.demo.converter.service.ExtendedConversionService;
import com.app.demo.converter.service.ExtendedConversionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Configuration
@ComponentScan("com.app.demo.converter")
public class ConversionConfig {
    @Bean
    ExtendedConversionService extendedConversionService(List<Converter> converters) {
        ExtendedConversionServiceImpl bean = new ExtendedConversionServiceImpl();
        converters.forEach(bean::addConverter);
        return bean;
    }
}
