package uz.prostream.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.prostream.blog.entity.Role;
import uz.prostream.blog.entity.enums.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
