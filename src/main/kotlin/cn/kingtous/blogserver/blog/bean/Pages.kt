package cn.kingtous.blogserver.blog.bean

import org.springframework.context.annotation.Primary
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
public class Pages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var pageId: Int = 0

    var createDate: Date = Date(0)

    var title: String = ""

    var subtitle: String = ""

    var tags: String = ""

    var content: String = ""
}