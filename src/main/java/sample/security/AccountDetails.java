package sample.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String password = "password";
    private String username = "landwarrior";

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public String getPassword() {
		System.out.println("hogehoge");
		return this.password;
	}

	@Override
	public String getUsername() {
		System.out.println("fugafuga");
		return this.username;
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

	@Override
	public boolean isEnabled() {
		return true;
	}

}
