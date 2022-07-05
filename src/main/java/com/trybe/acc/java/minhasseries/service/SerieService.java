package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.domain.Tempo;
import com.trybe.acc.java.minhasseries.exception.AlreadyExistsException;
import com.trybe.acc.java.minhasseries.exception.NotFoundException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class SerieService.
 */
@Service
public class SerieService {

  /** The repo. */
  @Autowired
  private SerieRepository repo;

  /**
   * Creates the.
   *
   * @param serieNova the serie nova
   * @return the serie
   */
  public Serie create(Serie serieNova) {
    if (repo.existsByNome(serieNova.getNome())) {
      throw new AlreadyExistsException("Série Existente");
    }
    return repo.save(serieNova);
  }

  /**
   * Find all.
   *
   * @return the list
   */
  public List<Serie> findAll() {
    return repo.findAll();
  }

  /**
   * Delete.
   *
   * @param serieId the serie id
   */
  public void delete(Integer serieId) {
    repo.findById(serieId)
        .orElseThrow(() -> new NotFoundException("Série não encontrada"));
    repo.deleteById(serieId);
  }

  {
    // TODO Auto-generated method stub

  }

  /**
   * Adds the episode.
   *
   * @param serieId  the serie id
   * @param episodio the episodio
   * @return the serie
   */
  public Serie addEpisode(Integer serieId, Episodio episodio) {
    return repo.findById(serieId).map(serie -> {
      if (serie.getEpisodios().contains(episodio)) {
        throw new AlreadyExistsException("Episódio Existente");
      }
      episodio.setSerie(serie);
      serie.adicionarEpisodio(episodio);
      return repo.save(serie);
    }).orElseThrow(() -> new NotFoundException(""));
  }

  /**
   * List episodes.
   *
   * @param serieId the serie id
   * @return the list
   */
  public List<Episodio> listEpisodes(Integer serieId) {
    Serie findEpisodio = repo.findById(serieId).orElse(null);
    if (findEpisodio == null) {
      throw new AlreadyExistsException("Episódio Não Existente");
    }
    return findEpisodio.getEpisodios();
  }

  /**
   * Tempo series.
   *
   * @return the tempo
   */
  public Tempo tempoSeries() {
    Integer tempoTotal = repo.findAll().stream().map(Serie::tempoTotal)
        .reduce(0, (total, minutos) -> total + minutos);
    return new Tempo(tempoTotal);
  }

}
