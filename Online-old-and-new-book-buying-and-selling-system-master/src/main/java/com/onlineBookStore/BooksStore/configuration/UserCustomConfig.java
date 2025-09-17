package com.onlineBookStore.BooksStore.configuration;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onlineBookStore.BooksStore.Entities.User;

public class UserCustomConfig implements UserDetails {

    private User user;

    public UserCustomConfig(User u) {
        this.user = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> auths = new HashSet<>();
        if (user.getRole() != null && !user.getRole().isEmpty()) {
            // your roles seem to be stored as "ROLE_USER" or "ROLE_ADMIN"
            auths.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return auths;
    }

    @Override public String getPassword() { return user.getUserPassword(); }
    @Override public String getUsername() { return user.getUserEmail(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return user.isEnabled(); }
}




//package com.onlineBookStore.BooksStore.configuration;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.onlineBookStore.BooksStore.Entities.User;
//
//public class UserCustomConfig implements UserDetails {
//	private User user;
//
//	public UserCustomConfig(User u) {
//		super();
//		this.user = u;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		HashSet<SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
//		set.add(new SimpleGrantedAuthority(user.getRole()));
//		return set;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getUserPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getUserEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
