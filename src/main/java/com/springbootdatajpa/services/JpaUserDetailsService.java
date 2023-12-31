package com.springbootdatajpa.services;

import com.springbootdatajpa.models.dao.IUsuarioDao;
import com.springbootdatajpa.models.entity.Role;
import com.springbootdatajpa.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario == null){
            logger.error("Error login: no existe el usuario  '"+ username+ "'");
            throw new UsernameNotFoundException("Username "+ username + " no existe en el sistema!");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role: usuario.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (authorities.isEmpty()){
            logger.error("Error login: usuario  '"+ username+ "' no tiene roles asignado!");
            throw new UsernameNotFoundException("Error login: usuario '" + username+  "'+  no tiene loles asignados!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }
}
