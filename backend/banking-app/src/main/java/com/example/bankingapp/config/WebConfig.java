// package com.example.bankingapp.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class WebConfig {

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**")
//                         .allowedOrigins("http://localhost:3000") // Allow frontend origin
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Include OPTIONS for preflight
//                         .allowedHeaders("*")
//                         .allowCredentials(true); // Allow cookies or authentication headers
//             }
//         };
//     }
// }


package com.example.bankingapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // You can leave this empty or delete it if not needed for other configurations
}
