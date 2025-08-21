package com.emmily.api_produtos.controller;

import com.emmily.api_produtos.model.Usuario;
import com.emmily.api_produtos.security.JwtUtil;
import com.emmily.api_produtos.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), "password");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<Usuario> usuario = usuarioService.buscarPorUserName(request.get("username"));

        if(usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))){
            String token = JwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}
