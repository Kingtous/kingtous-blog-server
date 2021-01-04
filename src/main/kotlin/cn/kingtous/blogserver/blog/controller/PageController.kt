package cn.kingtous.blogserver.blog.controller

import cn.kingtous.blogserver.blog.bean.Pages
import cn.kingtous.blogserver.blog.repository.PagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.sql.Time
import java.util.*
import kotlin.math.min

@RestController
public class PageController {

    @Autowired
    private lateinit var pagesRepository: PagesRepository

    private val perPageCount = 10
    private val contentDescCount = 128

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
        val pages = pagesRepository.findAll(PageRequest.of(pageIndex, perPageCount, Sort.by(Sort.Order.desc("createDate"))))
        pages.forEach{
            val dataDecoded = Base64.getDecoder().decode(it.content)
            it.content = String(Arrays.copyOfRange(dataDecoded,0,contentDescCount))
        }
        return pages
    }

    /**
     * 搜索
     */
    @GetMapping(value = ["/blog/search"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun searchPages(@RequestParam(value = "offset", required = true) offset: Int,@RequestParam(value = "keyword", required = true) keyword: String): Page<Pages> {
        val pages =  pagesRepository.findAllByTitleLikeOrSubtitleLike(keyword,keyword,Base64.getEncoder().encodeToString(keyword.toByteArray()),PageRequest.of(offset,perPageCount))
        pages.forEach {
            val dataDecoded = Base64.getDecoder().decode(it.content)
            it.content = String(Arrays.copyOfRange(dataDecoded,0,contentDescCount))
        }
        return pages
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