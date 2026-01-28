package org.example.gameapp.repository;

import org.example.gameapp.entities.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    // Spring crea la consulta automáticamente basándose en el nombre del método
    List<Videojuego> findByPlatform(String platform);
}