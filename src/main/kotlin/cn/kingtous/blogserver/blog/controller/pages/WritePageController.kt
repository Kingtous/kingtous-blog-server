package cn.kingtous.blogserver.blog.controller.pages

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.servlet.ModelAndView

@Controller
class WritePageController {

    @GetMapping(value = ["/blog/write"])
    fun index(): ModelAndView {
        val data = HashMap<String, String>()
        return ModelAndView("blog/write")
    }

    @PostMapping(value = ["/blog/write"])
    fun upload(@RequestBody body: Map<String,String>) : ModelAndView {
        return ModelAndView("blog/write")
    }

}