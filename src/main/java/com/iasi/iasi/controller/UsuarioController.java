package com.iasi.iasi.controller;

import com.iasi.iasi.model.Usuario;
import com.iasi.iasi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String mostrarPaginaDeRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @GetMapping("/login")
    public String mostrarPaginaDeLogin() {
        return "login";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.registrarUsuario(usuario);
        model.addAttribute("mensagem", "Usuário registrado com sucesso.");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nomeUsuario, @RequestParam String senhaUsuario, Model model) {
        boolean loginSucesso = usuarioService.verificarCredenciais(nomeUsuario, senhaUsuario);
        if (loginSucesso) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("erro", "Nome de usuário ou senha inválidos.");
            return "login";
        }
    }
}
