package vn.iotstar.configs;

import vn.iotstar.interceptor.AuthInterceptor_23110187;
import vn.iotstar.interceptor.RoleInterceptor_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor_23110187 authInterceptor;

    @Autowired
    private RoleInterceptor_23110187 roleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Bắt buộc login (trừ public path)
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");

        // Phân quyền theo role
        registry.addInterceptor(roleInterceptor)
                .addPathPatterns("/user/**", "/manager/**", "/admin/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ✅ Map URL /image/** tới thư mục chứa ảnh
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:///D:/Ki1_Nam3/ltWeb/Anh_btth/");

        // ✅ Map URL /video/** tới thư mục chứa video
        registry.addResourceHandler("/video/**")
                .addResourceLocations("file:///D:/Ki1_Nam3/ltWeb/VideoUploads/");
    }


}
