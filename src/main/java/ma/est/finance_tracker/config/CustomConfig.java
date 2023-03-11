package ma.est.finance_tracker.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
