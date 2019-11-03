package com.example.springjsonstreamtest.system;

import com.github.rozidan.springboot.modelmapper.ConfigurationConfigurer;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfiguration extends ConfigurationConfigurer {

    @Override
    public void configure(Configuration configuration) {
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
    }

}
