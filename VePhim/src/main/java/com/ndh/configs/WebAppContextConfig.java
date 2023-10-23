/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndh.formatter.ChoNgoiFormatter;
import com.ndh.formatter.NguoiDungFormatter;
import com.ndh.formatter.PhimFormatter;
import com.ndh.formatter.PhongChieuFormatter;
import com.ndh.formatter.RapPhimFormatter;
import com.ndh.formatter.SuatChieuFormatter;
import com.ndh.formatter.ChoNgoiSuatChieuFormatter;
import com.ndh.formatter.VaiTroFormatter;
import com.ndh.formatter.VeFormatter;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Duc Hung
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ndh.controllers",
    "com.ndh.repository",
    "com.ndh.service"
})
@PropertySource("classpath:configs.properties")
public class WebAppContextConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new VaiTroFormatter());
        registry.addFormatter(new RapPhimFormatter());
        registry.addFormatter(new PhimFormatter());
        registry.addFormatter(new PhongChieuFormatter());
        registry.addFormatter(new SuatChieuFormatter());
        registry.addFormatter(new ChoNgoiFormatter());
        registry.addFormatter(new NguoiDungFormatter());
        registry.addFormatter(new ChoNgoiSuatChieuFormatter());
        registry.addFormatter(new VeFormatter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
    }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setViewClass(JstlView.class);
//        r.setPrefix("WEB-INF/pages/");
//        r.setSuffix(".jsp");
//        return r;
//    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
                        "api_key", this.env.getProperty("cloudinary.api_id"),
                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
                        "secure", true));
        return cloudinary;
    }

//    @Bean
//    public SimpleDateFormat simpleDateFormat() {
//        return new SimpleDateFormat("yyyy-MM-dd");
//    }
}
