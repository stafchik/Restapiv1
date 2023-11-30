package com.spring.security.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Getter
    @Column(name = "role_name")
    private String roleName;

    @Transient
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> userSet = new HashSet<>();

    @Override
    public String getAuthority() {
        return this.roleName;
    }

    @Override
    public String toString() {
        if (roleName.equals("ROLE_ADMIN")) {
            return "ADMIN";
        } else {
            return "USER";
        }
    }
}
