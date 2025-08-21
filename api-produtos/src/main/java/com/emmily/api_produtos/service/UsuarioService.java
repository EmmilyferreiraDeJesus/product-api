package com.emmily.api_produtos.service;

import com.emmily.api_produtos.model.Usuario;
import com.emmily.api_produtos.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return usuarioRepository.save(usuario);

    }

    public Optional<Usuario> buscarPorUserName(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
