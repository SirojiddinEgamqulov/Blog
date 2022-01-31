package uz.prostream.blog.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.config.Projection;
import uz.prostream.blog.entity.Blog;

import java.time.Instant;
import java.util.Map;

@Projection(types = Blog.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogProjection {
    Long id;
    String title;
    String content;
    Map<String, String> slug;
    Instant createdAt;
    Instant updatedAt;
}
