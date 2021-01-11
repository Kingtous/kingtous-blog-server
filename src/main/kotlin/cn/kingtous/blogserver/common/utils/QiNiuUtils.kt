package cn.kingtous.blogserver.common.utils

import cn.kingtous.blogserver.common.constants.UploadProperties
import com.qiniu.storage.Configuration
import com.qiniu.storage.Region
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

object QiNiuUtils {

    private val cfg = Configuration(Region.region0())
    private val uploadManager: UploadManager = UploadManager(cfg)

    fun uploadImage(file: MultipartFile) : String {
        val auth = Auth.create(UploadProperties.accessKey, UploadProperties.secretKey)
        val token = auth.uploadToken(UploadProperties.bucket)
        try {
            val filename = file.originalFilename
            filename?.let {
                val suffix = it.substring(it.lastIndexOf('.'))
                val fileKey = "${UUID.randomUUID()}$suffix"
                val response = uploadManager.put(file.inputStream,fileKey,token,null,null)
                return UploadProperties.domain + fileKey
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }
}