package org.example.gameapp.Controller;

import org.example.gameapp.entities.Videojuego;
import org.example.gameapp.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VideojuegoWebController {

    @Autowired
    private VideojuegoRepository repository;

    // Ruta para ver todos los juegos
    @GetMapping("/")
    public String listarTodos(Model model) {
        List<Videojuego> lista = repository.findAll();
        model.addAttribute("juegos", lista);
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
    // Ruta para el detalle del juego
    @GetMapping("/juego/{id}")
    public String detalleJuego(@PathVariable Long id, Model model) {
        model.addAttribute("juego", repository.findById(id).orElseThrow());
        return "detalle"; // Esto buscará detalle.html en templates
    }

    // Ruta para el formulario (Sirve para ambos: Nuevo y Editar)
    @GetMapping("/juego/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("tituloPagina", "Añadir Nuevo Juego");
        return "formulario"; // Crearemos este archivo HTML
    }

    // Ruta para editar un juego existente
    @GetMapping("/juego/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Videojuego videojuego = repository.findById(id).orElseThrow();
        model.addAttribute("videojuego", videojuego);
        model.addAttribute("tituloPagina", "Editar Juego");
        return "formulario"; // Usamos la misma plantilla
    }

    // Ruta para guardar los datos
    @PostMapping("/juego/guardar")
    public String guardarJuego(@ModelAttribute("videojuego") Videojuego juego) {
        juego.setUserId(2L); // USUARIO EXISTE, USADO PARA DEV
        repository.save(juego);
        return "redirect:/";
    }
}