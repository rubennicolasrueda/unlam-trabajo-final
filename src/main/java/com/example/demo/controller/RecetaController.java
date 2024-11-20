package com.example.demo.controller;

import com.example.demo.dto.RecetaSemana;
import com.example.demo.model.Ingrediente;
import com.example.demo.model.Receta;
import com.example.demo.model.Usuario;
import com.example.demo.service.IngredienteService;
import com.example.demo.service.RecetaService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import weka.classifiers.bayes.NaiveBayes;


import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/arma-receta")
    public String armaRecetas(Model model) {
        List<String> optionsDropDownIngredientes = ingredienteService.obtenerNombresIngredientes();
        model.addAttribute("ingredientes", optionsDropDownIngredientes);
        List<String> optionsDropDownCategorias = recetaService.obtenerCategorias();
        model.addAttribute("categorias", optionsDropDownCategorias);
        return "perfil-usuario/arma-recetas";
    }

    @GetMapping("/mis-recetas")
    public String misRecetas(Model model) throws Exception {

        Long usuarioId = usuarioService.obtenerUsuario();
        model.addAttribute("recetas", recetaService.obtenerMisRecetas(usuarioId));
        List<Ingrediente> allIngredients = ingredienteService.obtenerIngredientes();
        model.addAttribute("recetasRecomendadas", recetaService.obtenerRecetaRecomendada(usuarioId, allIngredients));

        return "perfil-usuario/mis-recetas";
    }

    @GetMapping("/mi-recomendacion")
    public String miRecomendacion() {
        return "perfil-usuario/mis-recetas";
    }

    @GetMapping("/arma-receta-ingredientes")
    @ResponseBody
    public List<Receta> obtenerRecetasPorIngredientes(@RequestParam List<String> ingredientes) {
        Receta receta = recetaService.obtenerRecetaPorIngredientes(ingredientes);
        // Receta receta = recetaService.obtenerRecetaPorIngredientes(List.of("Lechuga"));
        // System.out.println(receta);
        // model.addAttribute("recetas", List.of(receta));
        // return "perfil-usuario/arma-recetas" ;
        return List.of(receta);
    }

    // ToDO -eliminar
    @GetMapping("/arma-receta-categoria")
    public String obtenerRecetasPorCategoria(Model model, @RequestParam String categoria) {
        List<RecetaSemana> recetas = recetaService.obtenerSemanaRecetasPorCategoria(categoria);
        model.addAttribute("recetasSemana", recetas);
        List<String> optionsDropDownIngredientes = ingredienteService.obtenerNombresIngredientes();
        model.addAttribute("ingredientes", optionsDropDownIngredientes);
        List<String> optionsDropDownCategorias = recetaService.obtenerCategorias();
        model.addAttribute("categorias", optionsDropDownCategorias);
        return "perfil-usuario/arma-recetas" ;
    }

    @GetMapping("/mis-pedidos")
    public String misPedidos(Model model){
        Long usuarioId = usuarioService.obtenerUsuario();
        model.addAttribute("pedidos", recetaService.obtenerMisPedidos(usuarioId));
        return "perfil-usuario/mis-pedidos";
    }

    @PostMapping("/mis-pedidos/agregar-pedido")
    public String agregarAPedido(Model model, @RequestParam Long id){
        Receta receta = recetaService.obtenerRecetaPorId(id);
        Long usuarioId = usuarioService.obtenerUsuario();
        recetaService.agregarIngredientesAlPedido(usuarioId, receta.getRecetaIngredientes());
        System.out.println("PEDIDO AGREGADO");
        return "perfil-usuario/mis-pedidos";
    }

    @PostMapping("/guarda-receta")
    public String guardarReceta(@RequestBody Receta receta) {
        recetaService.guardarReceta(receta.getTitulo());
        return "perfil-usuario/arma-recetas" ;
    }

    @GetMapping("/imprimir")
    public ResponseEntity<byte[]> imprimir() throws IOException {
        return recetaService.imprimir("receta");
    }

}
