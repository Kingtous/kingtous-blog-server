package cn.kingtous.blogserver.blog.bean

import org.springframework.context.annotation.Primary
import java.util.*
import javax.persistence.*

@Entity
public class Pages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var pageId: Int = 0

    var createDate: Date = Date()

    var title: String = ""

    var subtitle: String = ""

    var tags: String = ""

    @Column(columnDefinition = "mediumtext")
    var content: String = ""
}