package com.example.demo.service;

import com.example.demo.dto.RecetaSemana;
import com.example.demo.model.*;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.RecetaRepository;
import com.example.demo.repository.RecomendacionRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecetaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private RecomendacionRecetaRepository recomendacionRecetaRepository;

    @Autowired
    private RecetaBayesService recetaBayesService;


    public Receta obtenerRecetaPorIngredientes(List<String> ingredientes) {
        List<Receta> recetas = recetaRepository.findByIngredientesIn(ingredientes);
        return recetas.stream()
                .skip(new Random().nextInt(recetas.size()))
                .findFirst()
                .orElse(null); //todo agregar .orElseThrow(() -> new Exception
    }

    /*
    public Receta obtenerRecetaPorCategoria(String categoria) {
        List<Receta> recetas = obtenerRecetasPorCategoria(categoria);
        return recetas.stream()
                .skip(new Random().nextInt(recetas.size()))
                .findFirst()
                .orElse(null); //todo agregar .orElseThrow(() -> new Exception
    }

     */
    public List<RecetaSemana> obtenerSemanaRecetasPorCategoria(String categoria) {
        List<Receta> recetas = obtenerRecetasPorCategoria(categoria);
        List<RecetaSemana> recetasSemana = new ArrayList<RecetaSemana>();

        RecetaSemana recetaSemanaAlmuerzo = new RecetaSemana (
                "Almuerzo",
                recetas.get(0).getDescripcion(),
                recetas.get(1).getDescripcion(),
                recetas.get(2).getDescripcion(),
                recetas.get(3).getDescripcion(),
                recetas.get(4).getDescripcion(),
                recetas.get(5).getDescripcion(),
                recetas.get(6).getDescripcion()
        );

        recetasSemana.add(recetaSemanaAlmuerzo);
        System.out.println(recetas.size());
        if(recetas.size() > 13) {

            RecetaSemana recetaSemanaCena = new RecetaSemana (
                    "Cena",
                    recetas.get(7).getDescripcion(),
                    recetas.get(8).getDescripcion(),
                    recetas.get(9).getDescripcion(),
                    recetas.get(10).getDescripcion(),
                    recetas.get(11).getDescripcion(),
                    recetas.get(12).getDescripcion(),
                    recetas.get(13).getDescripcion()
                    );
            recetasSemana.add(recetaSemanaCena);
        }

        return recetasSemana;
    }


    public List<Receta> obtenerRecetasPorCategoria(String categoria) {
        List<Receta> recetas = recetaRepository.findByCategoria(categoria);
        obtenerRecetasParaLaSemana(recetas);
        return recetas;
    }

    private List<Receta> obtenerRecetasParaLaSemana(List<Receta> recetas){
        System.out.println(recetas.size());
        return recetas.stream()
                .skip(new Random().nextInt(recetas.size()))
                .limit(14)  // Limit to 7 elements
                .collect(Collectors.toList()); //todo agregar .orElseThrow(() -> new Exception
    }


    public void guardarReceta(String receta) {
        Receta receta1 = recetaRepository.findByTitulo("Ensalada de palta y tomate");
        RecomendacionReceta recomendacionReceta = new RecomendacionReceta((long)1, receta1.getId(), LocalDate.now(), LocalDate.now());
        recomendacionRecetaRepository.save(recomendacionReceta);
    }

    public void imprimir(Receta receta) {
    }

    public ResponseEntity<byte[]> imprimir(String receta) throws IOException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(Files.readAllBytes(Paths.get(new ClassPathResource("static/pdf/print-full.pdf").getURI())));
    }

    public List<String> obtenerCategorias() {
        return categoriaRepository.getDescripcionAll() ;
    }

    public Set<Receta> getRecetasByUsuario(Long id) {
        return recetaRepository.findByIdUsuario(id) ;
    }

    public List<Receta> obtenerRecetas() {
          List<Receta> recetas = new ArrayList<>();
          recetaRepository.findAll().forEach(recetas::add);
        return recetas;
    }

    public Receta obtenerRecetaRecomendada(Long usuarioId, List<Ingrediente> ingredientes) throws Exception {

        Receta recetaRecomendada = null;

        // Receta receta = recetaService.obtenerRecetaPorIngredientes(List.of("Tomate"));
        List<Receta> allRecipes = obtenerRecetas();
        Set<Receta> likedRecipes = getRecetasByUsuario(usuarioId);

        // Instances instances = recetaBayesService.trainModel(allRecipes, likedRecipes, ingredientes);

        recetaBayesService.entrenar(allRecipes, likedRecipes, ingredientes);

        for (Receta receta : allRecipes) {
            if (!likedRecipes.contains(receta)) {
                // TrainingRecord record = ;
                recetaRecomendada = recetaBayesService.predecirReceta(ingredientes, receta);
                //System.out.println(record);
            }

            if( recetaRecomendada != null ) break;
        }
        // recetaBayesService.predecirReceta(allRecipes, likedRecipes, ingredientes, allRecipes.get(allRecipes.size()-1));

        return recetaRecomendada;
    }

    public List<Receta> obtenerMisRecetas(Long usuarioId) {
        return recetaRepository.obtenerMisRecetasPorUsuario(usuarioId);
    }
}
