package spr.security.practise.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import spr.security.practise.Services.CustomeUserService;

@Configuration
public class MySecurity {

    @Autowired
    private CustomeUserService userService;

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     return new InMemoryUserDetailsManager(
    //         User.withUsername("harsh")
    //         .password(passwordEncoder().encode("123456"))
    //         .roles("NORMAL")
    //         .build(),
    //         User.withUsername("Daksh")
    //         .password(passwordEncoder().encode("654321"))
    //         .roles("ADMIN")
    //         .build()
    //     );
    // }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(t -> t
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/signin").permitAll()
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/user"))
                .logout(logout->logout
                .permitAll());
        return http.build();
    }

}
