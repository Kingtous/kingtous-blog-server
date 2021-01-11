package cn.kingtous.blogserver.common.controller

import cn.kingtous.blogserver.common.constants.UrlConstants
import cn.kingtous.blogserver.common.utils.QiNiuUtils
import org.springframework.stereotype.Controller
import java.util.HashMap

import java.io.IOException

import java.util.UUID

import javax.servlet.http.HttpServletRequest

import org.springframework.web.multipart.MultipartFile

import org.springframework.web.bind.annotation.RequestParam

import org.springframework.web.bind.annotation.ResponseBody

import org.springframework.web.bind.annotation.RequestMethod

import org.springframework.web.bind.annotation.RequestMapping
import org.thymeleaf.util.TextUtils
import java.io.File


@Controller
class ImageUploadController {


    // TODO 接入七牛云
    @RequestMapping(value = ["/img/upload"], method = [RequestMethod.POST])
    @ResponseBody
    fun uploadImg(
        @RequestParam(value = "editormd-image-file", required = true) multipartFile: MultipartFile,
        request: HttpServletRequest
    ): Map<String, Any>? {
        // TODO 鉴权
        val url = QiNiuUtils.uploadImage(multipartFile)
        return if (url.isEmpty()){
            // 返回的数据结果
            val result: MutableMap<String, Any> = HashMap()
            result["success"] = -1
            result["message"] = "图片上传失败"
            result
        } else {
            // 返回的数据结果
            val result: MutableMap<String, Any> = HashMap()
            result["success"] = 1
            result["message"] = "图片上传成功"
            result["url"] = url
            result
        }
    }

}