package uz.prostream.blog.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.prostream.blog.entity.enums.RoleName;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}

