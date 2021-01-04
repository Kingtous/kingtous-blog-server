package cn.kingtous.blogserver.blog.test

import cn.kingtous.blogserver.blog.repository.PagesRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringRunner::class)
@WebAppConfiguration
@SpringBootTest
class BlogTest {

    @Autowired
    lateinit var repository : PagesRepository

    @Test
    public fun testSearch(){
        val result = repository.findAllByTitleLikeOrSubtitleLike("测试","测试","测试",PageRequest.of(0,10))
        System.out.println(result)
    }

    @Test
    public fun testGetBlogs(){
        val result = repository.findAll(PageRequest.of(0,10))
        System.out.println(result)
    }

    @Test
    public fun testGetBlogById(){
        val result = repository.findPagesByPageId(1)
        System.out.println(result)
    }
}