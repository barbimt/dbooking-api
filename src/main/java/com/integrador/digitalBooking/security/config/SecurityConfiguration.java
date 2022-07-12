package com.integrador.digitalBooking.security.config;

import com.integrador.digitalBooking.security.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/usuarios").permitAll()
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/usuarios/user/**").permitAll()
                .antMatchers("/ciudades").permitAll()
                .antMatchers("/categorias").permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/reservas").permitAll()
                .antMatchers("/reservas/productos/**").permitAll()
                .antMatchers("/productos/**").permitAll()
                .antMatchers("/productos/ciudad/**/**/**").permitAll()
                .antMatchers("/productos").permitAll()
                .antMatchers("/ubicaciones").permitAll()
                .antMatchers("/caracteristicas").permitAll()
                .antMatchers("/politicas").permitAll()
                .antMatchers("/imagenes").permitAll()
                .antMatchers("/descripciones").permitAll()
                .antMatchers("/reservas/**").permitAll()
                .antMatchers("/swagger-ui/**" , "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                .antMatchers("/administracion").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/query").hasAuthority("ROLE_CLIENT")
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
