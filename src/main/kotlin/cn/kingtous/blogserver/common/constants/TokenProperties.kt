package cn.kingtous.blogserver.common.constants

import org.apache.tomcat.jni.Local
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import javax.crypto.SecretKey

@Configuration
@ConfigurationProperties(prefix = "token")
class TokenProperties {
    var blogPost: String? = null
}