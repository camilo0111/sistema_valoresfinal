package com.sistema_valores.config;

import com.sistema_valores.model.Usuario;
import com.sistema_valores.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class UserInfoAdvice {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ModelAttribute("usuarioRol")
    public String agregarRolUsuarioAlModelo(Principal principal) {
        if (principal == null) return "invitado";

        return usuarioRepository.findByEmail(principal.getName())
                .map(usuario -> usuario.getTipo_usuario().name().toLowerCase()) // Ej: "secretario"
                .orElse("invitado");
    }
}
