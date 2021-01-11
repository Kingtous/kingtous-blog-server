package cn.kingtous.blogserver.blog.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PageWebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/blog/**")
            .allowedHeaders("*")
            .allowedMethods("GET","POST")
            .maxAge(1800)
            .allowedOrigins("*") // TODO replace after production
    }
}