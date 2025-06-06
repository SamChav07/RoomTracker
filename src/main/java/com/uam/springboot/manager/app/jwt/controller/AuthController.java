package com.uam.springboot.manager.app.jwt.controller;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.UsuarioRequestDTO;
import com.uam.springboot.manager.app.jwt.dto.AuthRequestDTO;
import com.uam.springboot.manager.app.jwt.dto.AuthResponseDTO;
import com.uam.springboot.manager.app.jwt.service.AuthService;
import com.uam.springboot.manager.app.service.impl.catalogos.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;
// Se manejan las rutas relacionadas con autenticacion.

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO request) {
        AuthResponseDTO authResponse = authService.login(request);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/registry")
    public ResponseEntity<AuthResponseDTO> register (@Valid @RequestBody UsuarioRequestDTO request) {
        try {
            usuarioService.create(request);

            AuthResponseDTO authResponse = authService.login(new AuthRequestDTO(request.email(), request.password()));
            return ResponseEntity.ok(authResponse);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(new AuthResponseDTO(e.getMessage()));
        }
    }
}
