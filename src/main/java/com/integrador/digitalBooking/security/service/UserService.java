package com.integrador.digitalBooking.security.service;

import com.integrador.digitalBooking.model.Usuario;
import com.integrador.digitalBooking.repository.IUsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Consultara email" + email + " en base de datos");
        Usuario usuario = repository.findByEmail(email);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));

        log.info("Usuario autenticado: " + email);

        return new User(email, usuario.getClave(), true, true, true, true, authorities);
    }
}
