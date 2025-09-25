//package vn.iotstar.configs;
//
//import jakarta.servlet.Filter;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SiteMeshConfig {
//
//    @Bean
//    public FilterRegistrationBean<Filter> siteMeshFilter() {
//        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
//        filter.setFilter(new MySiteMeshFilter());
//        filter.addUrlPatterns("/*"); // áp dụng cho tất cả request
//        filter.setName("sitemeshFilter");
//        filter.setOrder(1); // chạy trước Interceptor
//        return filter;
//    }
//}	
