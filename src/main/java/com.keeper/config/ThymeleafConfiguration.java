package com.keeper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by Alexandr Vasiliev on 13.04.2017.
 *
 * @author Alexandr Vasiliev
 */
//@Configuration
public class ThymeleafConfiguration {
//    @Autowired
//    private ThymeleafProperties properties;
//
//    @Value("${spring.thymeleaf.templates_root:}")
//    private String templatesRoot;
//
//    @Bean
//    public ITemplateResolver defaultTemplateResolver() {
//        TemplateResolver resolver = new FileTemplateResolver();
//        resolver.setSuffix(properties.getSuffix());
//        resolver.setPrefix(templatesRoot);
//        resolver.setTemplateMode(properties.getMode());
//        resolver.setCharacterEncoding(String.valueOf(properties.getEncoding()));
//        resolver.setCacheable(properties.isCache());
//        return resolver;
//    }
}

//@Configuration
//public class ThymeleafConfiguration {
//    @Bean
//    public ITemplateResolver defaultTemplateResolver() {
//        TemplateResolver resolver = new FileTemplateResolver();
//        resolver.setSuffix(".html");
//        resolver.setPrefix("path/to/your/templates");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setCacheable(false);
//        return resolver;
//    }
//}