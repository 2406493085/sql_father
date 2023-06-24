package com.yupi.sqlfather.config;


import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.freemarker.SpringTemplateLoader;

/**
 * FreeMarker 模板配置
 *
 * @author https://github.com/liyupi
 */

@org.springframework.context.annotation.Configuration
public class FreeMarkerConfigurationConfig {
    private static freemarker.template.Configuration cfg;
    @Autowired
    private ResourceLoader resourceLoader;
    @Bean
    public Configuration configuration() throws IOException {
        try{
            SpringTemplateLoader templateLoader = new SpringTemplateLoader(resourceLoader, "classpath:templates");
            cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
            cfg.setTemplateLoader(templateLoader);
            cfg.setDefaultEncoding("UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return cfg;
    }
}
