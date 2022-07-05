package com.trybe.acc.java.minhasseries.service;

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
        .orElseThrow(() -> new NotFoundException("Serie não encontrada"));
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
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * List episodes.
   *
   * @param serieId the serie id
   * @return the list
   */
  public List<Episodio> listEpisodes(Integer serieId) {
    // TODO Auto-generated method stub
    return null;
  }
  /*
   * public Tempo tempoSeries() { // TODO Auto-generated method stub return
   * null; }
   */

}
