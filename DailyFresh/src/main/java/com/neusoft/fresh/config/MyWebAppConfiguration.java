package com.neusoft.fresh.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring个性化配置
 */
@SuppressWarnings("deprecation")
@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter{
	private static final Logger logger=LoggerFactory.getLogger(MyWebAppConfiguration.class);
	
	@Value("${uploadPath}")
	String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("图片存放位置："+uploadPath);
		/**
		 * 设置Spring读取本地文件，相当于虚拟一个服务器
		 */
		//指定“/uploadPic/**”定向到本地路径
		registry.addResourceHandler("/uploadPic/**").addResourceLocations("file:"+uploadPath);
		
		//自定义静态资源映射
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/admin/");
		super.addResourceHandlers(registry);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册自定义拦截器，添加拦截路径和排除拦截路径  
//		registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/admin/index*","/admin/login*",
//				"/portal/login*","/portal/register*","/index.html","/error");
	}
}