package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import vn.iotstar.configs.MySiteMeshFilter;

@SpringBootApplication
public class De723110187Application {

	public static void main(String[] args) {
		SpringApplication.run(De723110187Application.class, args);
	}
	@Bean
	public FilterRegistrationBean<MySiteMeshFilter> siteMeshFilter() {
	FilterRegistrationBean<MySiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<MySiteMeshFilter>();
	filterRegistrationBean.setFilter(new MySiteMeshFilter()); 
	filterRegistrationBean.addUrlPatterns("/*");
	return filterRegistrationBean;

	}
}
