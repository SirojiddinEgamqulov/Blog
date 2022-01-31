package uz.prostream.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.prostream.blog.entity.Role;
import uz.prostream.blog.entity.User;
import uz.prostream.blog.entity.enums.RoleName;
import uz.prostream.blog.repository.RoleRepository;
import uz.prostream.blog.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    final
    UserRepository userRepository;
    final
    RoleRepository roleRepository;
    final
    PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository,
                      @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (initMode.equals("always")) {
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            userRepository.save(
                    new User(
                            "Admin",
                            "Admin",
                            "Admin",
                            "admin@gmail.com",
                            passwordEncoder.encode("root123"),
                            roleRepository.findByRoleName(RoleName.ROLE_ADMIN).orElseThrow()
                    )
            );
        }
    }

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
