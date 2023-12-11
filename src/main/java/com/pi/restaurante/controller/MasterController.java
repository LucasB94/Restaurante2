package com.pi.restaurante.controller;

import com.pi.restaurante.modal.Cadastro;
import com.pi.restaurante.modal.Comentario;
import com.pi.restaurante.modal.Reserva;
import com.pi.restaurante.service.CadastroService;
import com.pi.restaurante.service.ComentarioService;
import com.pi.restaurante.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MasterController {

    @Autowired
    CadastroService cadastroService;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    ReservaService reservaService;

    @GetMapping("/")
    public String viewHomePage() {
        return "redirect:/";
    }

    @GetMapping("/Pag_Inicial")
    public String exibirPag(Model model) {
        return "Pag_Inicial";
    }

    @GetMapping("/Cardapio")
    public String exibirCardapio(Model model) {
        return "Cardapio";
    }

    @GetMapping("/Localizacao")
    public String exibirLocalizacao(Model model) {
        return "Localizacao";
    }
    
    @GetMapping("/Cadastrar")
    public String exibirCadastro(Model model){
        model.addAttribute("cadastro", new Cadastro());
        return "Cadastrar";
    }
    
    @GetMapping("/Reserva")
    public String exibirReserva(Model model){
        model.addAttribute("reserva", new Reserva());
        
        return "Reserva";
    }
    
    @GetMapping("/Posso_Ajudar")
    public String exibirComentario(Model model){
        model.addAttribute("comentario", new Comentario());
        return "Posso_Ajudar";
    }
    
    @GetMapping("/criarCadastrar")
    public String criarCadastro(Model model) {
        Cadastro c = new Cadastro();
        model.addAttribute("cadastro", c);
        return "Cadastrar";
    }

    @GetMapping("/criarReserva")
    public String criarReserva(Model model) {
        Reserva r = new Reserva();
        model.addAttribute("reserva", r);
        return "Reserva";
    }

    @GetMapping("/criarComentario")
    public String criarComentario(Model model) {
        Comentario com = new Comentario();
        model.addAttribute("comentario", com);
        return "Posso_Ajudar";
    }

    @PostMapping("/salvarCadastrar")
    public String salvarCadastro(@ModelAttribute("cadastro") Cadastro c) {

        if (c.getId() == null) {
            cadastroService.criarCadastro(c);
        } else {
            cadastroService.atualizarCadastro(c.getId(), c);
        }

        return "redirect:/Cadastrar";
    }

    @PostMapping("/salvarReserva")
    public String salvarReserva(@ModelAttribute("reserva") Reserva r) {

        if (r.getId() == null) {
            reservaService.criarReserva(r);
        } else {
            reservaService.atualizarReserva(r.getId(), r);
        }

        return "redirect:/Reserva";
    }

    @PostMapping("/salvarComentario")
    public String salvarReseva(@ModelAttribute("comentario") Comentario com) {

        if (com.getId() == null) {
            comentarioService.criarComentario(com);
        } else {
            comentarioService.atualizarComentario(com.getId(), com);
        }

        return "redirect:/Pag_Inicial";
    }

    @GetMapping("/atualizarCadastrar/{id}")
    public String atualizarCadastro(@PathVariable(value = "id") Integer id, Model model) {

        Cadastro c = cadastroService.buscarCadastroPorId(id);
        model.addAttribute("cadastro", c);
        return "Cadastrar";
    }

    @GetMapping("/atualizarReserva/{id}")
    public String atualizarReserva(@PathVariable(value = "id") Integer id, Model model) {

        Reserva r = reservaService.buscarReservaPorId(id);
        model.addAttribute("reserva", r);
        return "Reserva";
    }

    @GetMapping("/atualizarComentario/{id}")
    public String atualizarComentario(@PathVariable(value = "id") Integer id, Model model) {

        Comentario com = comentarioService.buscarComentarioPorId(id);
        model.addAttribute("comentario", com);
        return "Posso_Ajudar";
    }

    @GetMapping("/deletarCadastrar/{id}")
    public String deletarCadastro(@PathVariable(value = "id") Integer id) {

        cadastroService.deletarCadastro(id);
        return "redirect:/Cadastrar";
    }

    @GetMapping("/deletarReserva/{id}")
    public String deletarReserva(@PathVariable(value = "id") Integer id) {

        reservaService.deletarReserva(id);
        return "redirect:/Reserva";
    }

    @GetMapping("/deletarComentario/{id}")
    public String deletarComentario(@PathVariable(value = "id") Integer id) {

        comentarioService.deletarComentario(id);
        return "redirect:/Posso_Ajudar";
    }
}
