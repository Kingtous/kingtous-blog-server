package cn.kingtous.blogserver

import cn.kingtous.blogserver.common.constants.UploadProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@EnableConfigurationProperties(
        UploadProperties::class
)
class BlogServerApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<BlogServerApplication>(*args)
}
