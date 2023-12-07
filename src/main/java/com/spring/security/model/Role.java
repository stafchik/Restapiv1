package com.spring.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> userSet = new HashSet<>();

    @Override
    public String getAuthority() {
        return roleName;
    }
    public String getRoleName() {
        return roleName.replaceAll("ROLE_","");
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
