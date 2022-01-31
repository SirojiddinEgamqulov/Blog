package uz.prostream.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.prostream.blog.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
