package com.keeper.config;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.sun.javafx.collections.MappingChange;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;

import javax.annotation.Resource;

/**
 * Default Comment
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.keeper"})
public class AppWebConfig extends WebMvcConfigurerAdapter {

    /**
     * Configure ResourceHandlers to serve static resources like CSS/Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getMultipartResolver() {
//        return new CommonsMultipartResolver();
//    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(viewResolver());
//        registry.viewResolver(setupViewResolver());
////        registry.viewResolver(tilesViewResolver());
//    }



//    @Bean
//    public MultipleViewResolver viewResolver() {
//        MappingChange.Map<String, ViewResolver> viewsResolvers = new HashMap<String, ViewResolver>();
//        viewsResolvers.put(MultipleViewResolver.ViewType.JSP.getKey(), jspViewResolver());
//        viewsResolvers.put(MultipleViewResolver.ViewType.TILES.getKey(), tilesViewResolver());
//
//        MultipleViewResolver viewResolver = new MultipleViewResolver();
//        viewResolver.setViewsResolvers(viewsResolvers);
//        viewResolver.setOrder(1);
//        return viewResolver;
//    }

//    @Bean
//    public ViewResolver getViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//
//    @Bean
//    public InternalResourceViewResolver setupViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//
//        return resolver;
//    }

//    @Bean
//    public UrlBasedViewResolver viewResolver() {
//        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//        urlBasedViewResolver.setViewClass(TilesView.class);
//        urlBasedViewResolver.setContentType("text/html;charset=UTF-8");
//        return urlBasedViewResolver;
//    }

}


