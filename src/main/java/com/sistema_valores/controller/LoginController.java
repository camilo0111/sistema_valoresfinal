package com.sistema_valores.controller;

import java.util.Optional;
import com.sistema_valores.model.Usuario;
import com.sistema_valores.repository.UsuarioRepository;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout,
                       @RequestParam(value = "registered", required = false) String registered,
                       Model model) {
        // Thymeleaf maneja los parámetros en la vista automáticamente
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          @RequestParam String tipo_usuario,
                          @RequestParam String nombre,
                          RedirectAttributes redirectAttributes) {
        try {
            // Validar longitud mínima
            if (password.length() < 8) {
                redirectAttributes.addFlashAttribute("error", "La contraseña debe tener al menos 8 caracteres.");
                return "redirect:/register";
            }

            // Validar confirmación de contraseña
            if (!password.equals(confirmPassword)) {
                redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden.");
                return "redirect:/register";
            }

            // Verificar si el usuario ya existe
            Optional<Usuario> existingUser = usuarioRepository.findByEmail(email);
            if (existingUser.isPresent()) {
                redirectAttributes.addFlashAttribute("error", "Ya existe un usuario con este email.");
                System.out.println("Intento de registro con email existente: " + email);
                return "redirect:/register";
            }

            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setPassword(passwordEncoder.encode(password));
            usuario.setTipo_usuario(Usuario.Rol.valueOf(tipo_usuario));
            usuario.setNombre(nombre);
            usuarioRepository.save(usuario);

            System.out.println("Usuario registrado correctamente: " + email + ", rol: " + tipo_usuario);

            // Redirigir con parámetro de éxito
            return "redirect:/login?registered";

        } catch (Exception e) {
            e.printStackTrace(); // Para depurar errores en consola
            redirectAttributes.addFlashAttribute("error", "Error al registrar usuario.");
            return "redirect:/register";
        }
    }

    @GetMapping("/inicio")
    public String inicio(Model model, Principal principal) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(principal.getName());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            model.addAttribute("usuarioRol", usuario.getTipo_usuario().name().toLowerCase());
            model.addAttribute("usuario", usuario);
        }
        return "inicio";
    }
}
