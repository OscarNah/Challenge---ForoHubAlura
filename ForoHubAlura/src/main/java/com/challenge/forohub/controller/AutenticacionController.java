package com.challenge.forohub.controller;

import com.challenge.forohub.infra.security.DtoJWTtoken;
import com.challenge.forohub.infra.security.TokenService;  // Importar el TokenService correcto
import com.challenge.forohub.model.usuario.DtoAutenticacionUsuario;
import com.challenge.forohub.model.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DtoAutenticacionUsuario dtoAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                dtoAutenticacionUsuario.login(),
                dtoAutenticacionUsuario.contrasena()
        );
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DtoJWTtoken(JWTtoken));
    }
}
