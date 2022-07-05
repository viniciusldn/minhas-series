package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataErrorException;
import com.trybe.acc.java.minhasseries.exception.NotFoundException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SerieController {

  @Autowired
  private SerieService service;

  @PostMapping("/series")
  public ResponseEntity<Serie> criar(@RequestBody Serie serie) {
    Serie serieSalva = service.create(serie);
    return ResponseEntity.status(HttpStatus.OK).body(serieSalva);
  }

  @GetMapping("/series")
  public ResponseEntity<List<Serie>> listarTodos() {
    List<Serie> series = service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(series);
  }

  @DeleteMapping("/series/{serie_id}")
  public ResponseEntity<Serie> deletar(
      @PathVariable("serie_id") Integer serieId) throws NotFoundException {
    service.delete(serieId);
    return ResponseEntity.ok().build();
  }

  @CircuitBreaker(name = "episodios", fallbackMethod = "fallback")
  @PostMapping("/series/{serie_id}/episodios")
  public ResponseEntity<Serie> adicionarEpisodio(@RequestBody Episodio episodio,
      @PathVariable("serie_id") Integer serieId) {
    Serie serieAtualizada = service.addEpisode(serieId, episodio);
    return ResponseEntity.status(HttpStatus.OK).body(serieAtualizada);
  }

  /**
   * adicionarEpisodio fallback.
   */
  public ResponseEntity<DataErrorException> fallback(
      @RequestBody Episodio episodio, @PathVariable("serie_id") Integer serieId,
      Exception e) {
    if (e.getClass() == NotFoundException.class) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(new DataErrorException(e.getMessage()));
    }
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
        .body(new DataErrorException("Serviço temporariamente indisponível"));
  }

  @GetMapping("/series/{serie_id}/episodios")
  public ResponseEntity<List<Episodio>> listarEpisodios(
      @PathVariable("serie_id") Integer serieId) {
    List<Episodio> serieAtualizada = service.listEpisodes(serieId);
    return ResponseEntity.status(HttpStatus.OK).body(serieAtualizada);
  }

  /*
   * @GetMapping("/series/tempo") public ResponseEntity<Tempo> tempoSeries() {
   * Tempo serieAtualizada = service.tempoSeries(); return
   * ResponseEntity.status(HttpStatus.OK).body(serieAtualizada); }
   */

}
