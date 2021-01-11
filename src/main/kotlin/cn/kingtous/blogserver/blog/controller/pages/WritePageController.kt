package cn.kingtous.blogserver.blog.controller.pages

import cn.kingtous.blogserver.blog.bean.Pages
import cn.kingtous.blogserver.blog.repository.PagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class WritePageController {

    @Autowired
    private lateinit var pagesRepository: PagesRepository

    @GetMapping(value = ["/blog/write"])
    fun index(): ModelAndView {
        val data = HashMap<String, String>()
        return ModelAndView("blog/write")
    }

}