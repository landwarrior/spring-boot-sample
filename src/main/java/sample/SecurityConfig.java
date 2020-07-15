package sample;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        System.out.println("hohoho");
        web.debug(false).ignoring().antMatchers("/js/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("fufufu");
        http
            .authorizeRequests()
            .mvcMatchers("/", "/signup").permitAll()
            .mvcMatchers("/members/user/**", "/images/user/**").hasRole("USER")
            .mvcMatchers("/members/admin/**", "/images/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .defaultSuccessUrl("/")
        .and()
            .logout()
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/");
    }
}
