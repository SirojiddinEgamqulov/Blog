package uz.prostream.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.prostream.blog.entity.Blog;
import uz.prostream.blog.projection.BlogProjection;

@CrossOrigin("*")
@RepositoryRestResource(path = "blog", collectionResourceRel = "list", excerptProjection = BlogProjection.class)
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
