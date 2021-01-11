package cn.kingtous.blogserver.common.constants

import org.apache.tomcat.jni.Local
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import javax.crypto.SecretKey

@Component
@ConfigurationProperties(prefix = "img-upload")
object UploadProperties {
    val domain: String? = null
    val accessKey: String? = null
    val secretKey: String? = null
    val bucket: String? = null
}