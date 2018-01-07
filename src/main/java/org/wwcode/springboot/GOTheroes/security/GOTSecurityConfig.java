package org.wwcode.springboot.GOTheroes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class GOTSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("pk").password("pk").roles("USER").build());
        userDetailsManager.createUser(User.withUsername("mc").password("mc").roles("ADMIN").build());

        return userDetailsManager;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);
        http.logout().logoutSuccessUrl("/heros.html").invalidateHttpSession(true);
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }
}
