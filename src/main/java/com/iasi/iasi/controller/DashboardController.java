package com.iasi.iasi.controller;

import com.iasi.iasi.model.Consumo;
import com.iasi.iasi.model.Equipamento;
import com.iasi.iasi.model.Empresa;
import com.iasi.iasi.repository.ConsumoRepository;
import com.iasi.iasi.repository.EquipamentoRepository;
import com.iasi.iasi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping
    public String dashboard() {
        return "dashboard"; // Nome do template HTML para o dashboard
    }

    @GetMapping("/empresas")
    public String empresas(Model model) {
        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);
        return "empresas"; // Nome do template HTML para listar empresas
    }

    @GetMapping("/equipamentos")
    public String equipamentos(Model model) {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        model.addAttribute("equipamentos", equipamentos);
        return "equipamentos"; // Nome do template HTML para listar equipamentos
    }

    @GetMapping("/consumos")
    public String consumos(Model model) {
        List<Consumo> consumos = consumoRepository.findAll();
        model.addAttribute("consumos", consumos);
        return "consumos"; // Nome do template HTML para listar consumos
    }

}
