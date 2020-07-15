package sample.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AccountDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("hogefuga");
        if (username == null) {
            throw new UsernameNotFoundException("user not found");
        }
        AccountDetails account = new AccountDetails();
        return account;
    }

}
