package cn.kingtous.blogserver.blog.repository

import cn.kingtous.blogserver.blog.bean.Pages
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository;

public interface PagesRepository : CrudRepository<Pages, Int> {

    fun findAll(page: Pageable): Page<Pages>


    fun findPagesByContent(content: String): Iterator<Pages>


    @Query(value = "select * from Pages as p where p.title like CONCAT('%',:title,'%') or p.subtitle like CONCAT('%',:subtitle,'%') or p.content like CONCAT('%',:content,'%')",nativeQuery = true)
    fun findAllByTitleLikeOrSubtitleLikeOrContentLike(
        content: String,
        title: String,
        subtitle: String,
        page: Pageable
    ): Page<Pages>


    fun findPagesByPageId(pageId: Int): Pages?

    fun tags(tag: String): List<String>
}