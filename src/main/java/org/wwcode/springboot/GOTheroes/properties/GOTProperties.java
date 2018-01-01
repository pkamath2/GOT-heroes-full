package org.wwcode.springboot.GOTheroes.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:heroes.properties")
public class GOTProperties {

    @Autowired
    Environment env;

    public String getProperty(String propName){
        return this.env.getProperty(propName);
    }
}
