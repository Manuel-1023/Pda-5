package com.almora.almora.Controller;

import org.springframework.security.core.Authentication;
import com.almora.almora.Model.Usuario;
import com.almora.almora.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable String id) { // Cambié Integer → String
        return usuarioService.getUsuarioById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) { // Cambié Integer → String
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable String id) { // Cambié Integer → String
        usuarioService.deleteUsuario(id);
    }

    @GetMapping("/correo/{correo}")
    public Optional<Usuario> getUsuarioByCorreo(@PathVariable String correo) {
        return usuarioService.getUsuarioByCorreo(correo);
    }

    @PostMapping("/admin")
    public Usuario crearAdmin(@RequestBody Usuario usuario) {
        usuario.setRol("ADMIN");
        return usuarioService.saveAdmin(usuario);
    }

    // ⭐ Obtener usuario logueado
    @GetMapping("/perfil")
    public Usuario getPerfilUsuario(Authentication authentication) {

        String correo = authentication.getName();

        return usuarioService.getUsuarioByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @GetMapping("/redirect")
    public String redirect(Authentication auth) {

        if (auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin.html";
        } else {
            return "redirect:/donante.html";
        }
    }

}
