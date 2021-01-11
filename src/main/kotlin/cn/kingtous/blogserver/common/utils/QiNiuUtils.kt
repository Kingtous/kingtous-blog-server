package cn.kingtous.blogserver.common.utils

import cn.kingtous.blogserver.common.constants.UploadProperties
import com.qiniu.storage.Configuration
import com.qiniu.storage.Region
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

object QiNiuUtils {

    private val cfg = Configuration(Region.region0())
    private val uploadManager: UploadManager = UploadManager(cfg)

    fun uploadImage(uploadProperties: UploadProperties,file: MultipartFile) : String {
        val auth = Auth.create(uploadProperties.accessKey, uploadProperties.secretKey)
        val token = auth.uploadToken(uploadProperties.bucket)
        try {
            val filename = file.originalFilename
            filename?.let {
                val suffix = it.substring(it.lastIndexOf('.'))
                val fileKey = "${UUID.randomUUID()}$suffix"
                val response = uploadManager.put(file.inputStream,fileKey,token,null,null)
                return "${uploadProperties.domain}/$fileKey"
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }
}