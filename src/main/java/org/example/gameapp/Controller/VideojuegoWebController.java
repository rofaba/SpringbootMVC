package org.example.gameapp.Controller;

import org.example.gameapp.entities.Videojuego;
import org.example.gameapp.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class VideojuegoWebController {

    @Autowired
    private VideojuegoRepository repository;

    // Ruta para ver todos los juegos
    @GetMapping("/")
    public String listarTodos(Model model) {
        List<Videojuego> lista = repository.findAll();
        model.addAttribute("juegos", lista); // 'juegos' es la clave que usaremos en el HTML
        return "index";
    }

    // Ruta para filtrar por plataforma
    @GetMapping("/plataforma/{nombre}")
    public String filtrarPorPlataforma(@PathVariable String nombre, Model model) {
        List<Videojuego> filtrados = repository.findByPlatform(nombre);
        model.addAttribute("juegos", filtrados);
        model.addAttribute("plataformaSeleccionada", nombre);
        return "index";
    }
    // Ruta para el detalle del juego (La tercera foto del whiteboard)
    @GetMapping("/juego/{id}")
    public String detalleJuego(@PathVariable Long id, Model model) {
        model.addAttribute("juego", repository.findById(id).orElseThrow());
        return "detalle"; // Esto buscará detalle.html en templates
    }
}