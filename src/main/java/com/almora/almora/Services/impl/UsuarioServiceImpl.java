package com.almora.almora.Services.impl;

import com.almora.almora.Model.Usuario;
import com.almora.almora.Repository.UsuarioRepository;
import com.almora.almora.Services.UsuarioService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {

        // ✅ Siempre DONANTE al registrarse
        usuario.setRol("DONANTE");

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario updateUsuario(String id, Usuario usuario) {
        usuario.setIdUsuario(id);
        usuario.setRol("DONANTE");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> getUsuarioByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }

    @Override
    public Usuario saveAdmin(Usuario usuario) {

        throw new UnsupportedOperationException("Unimplemented method 'saveAdmin'");
    }
}