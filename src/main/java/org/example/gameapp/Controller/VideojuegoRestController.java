package org.example.gameapp.Controller;


import org.example.gameapp.entities.Videojuego;
import org.example.gameapp.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoRestController {

    @Autowired
    private VideojuegoRepository repository;

    // Obtener todos los juegos
    @GetMapping
    public List<Videojuego> obtenerTodos() {
        return repository.findAll();
    }

    // Obtener un juego por ID (para la vista de detalle)
    @GetMapping("/{id}")
    public Videojuego obtenerPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Insertar un juego (útil para pruebas iniciales)
    @PostMapping
    public Videojuego guardar(@RequestBody Videojuego juego) {
        return repository.save(juego);
    }
}