package cn.kingtous.blogserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class BlogServerApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<BlogServerApplication>(*args)
}
