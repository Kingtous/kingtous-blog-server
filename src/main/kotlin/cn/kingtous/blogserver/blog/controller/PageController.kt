package cn.kingtous.blogserver.blog.controller

import cn.kingtous.blogserver.blog.bean.Pages
import cn.kingtous.blogserver.blog.repository.PagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
public class PageController {

    @Autowired
    private lateinit var pagesRepository: PagesRepository

    private val perPageCount = 10
    private val contentDescCount = 50

    /**
     * 获取文章
     */
    @ResponseBody
    @RequestMapping(
        value = ["/blog/list"],
        method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    public fun getPages(
        @RequestParam(
            value = "offset",
            required = true,
            defaultValue = "0"
        ) pageIndex: Int
    ): Page<Pages> {
        val pages = pagesRepository.findAll(PageRequest.of(pageIndex, perPageCount))
        pages.forEach{
            it.content = it.content.substring(0,contentDescCount)
        }
        return pagesRepository.findAll(PageRequest.of(pageIndex, perPageCount))
    }

    /**
     * 搜索
     */
    @GetMapping(value = ["/blog/search"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun searchPages(@RequestParam(value = "offset", required = true) offset: Int,@RequestParam(value = "keyword", required = true) keyword: String): Page<Pages> {
        return pagesRepository.findAllByTitleLikeOrSubtitleLikeOrContentLike(keyword,keyword,keyword,PageRequest.of(offset,perPageCount))
    }

    /**
     * 获取博客详情
     */
    @GetMapping(value = ["/blog/detail"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDetailById(@RequestParam(value = "id") id: Int): Pages?{
        return pagesRepository.findPagesByPageId(id)
    }

//    /**
//     * 搜索
//     */
//    @GetMapping(value = ["/blog/search"], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun searchPages(@RequestParam(value = "keyword", required = true) keyword: String): Page<Pages> {
//        return pagesRepository.findPagesByContentOrTitleOrSubtitle(keyword,keyword,keyword,PageRequest.of(0,perPageCount))
//    }

}