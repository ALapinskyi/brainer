package com.boss.brainer.domain.mysql;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name="enabled", columnDefinition="tinyint(1) default 1")
    private boolean enabled;

    /*@Lazy
    @OneToMany(mappedBy = "userId")
    private List<Friends> myFriends;

    @Lazy
    @OneToMany(mappedBy = "friendId")
    private List<Friends> otherFriends;

    public List<Friends> getFriends(){
        final ArrayList allFriends = new ArrayList();

        if(!CollectionUtils.isEmpty(myFriends))
            allFriends.addAll(myFriends);
        if(!CollectionUtils.isEmpty(otherFriends))
            allFriends.addAll(otherFriends);

        return allFriends;
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
