package org.ms.authentificationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="User_role")
    private Collection<AppRole> roles;
    public AppUser(Long id, String username, String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public void addRole(AppRole appRole){
        this.roles.add(appRole);
    }
}
