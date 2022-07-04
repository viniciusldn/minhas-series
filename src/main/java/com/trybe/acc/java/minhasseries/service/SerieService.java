package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.controller.Tempo;
import com.trybe.acc.java.minhasseries.exception.AlreadyExistsException;
import com.trybe.acc.java.minhasseries.exception.NotFoundException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  @Autowired
  private SerieRepository repo;

  public Serie create(Serie serieNova) {
    if (repo.existsByNome(serieNova.getNome())) {
      throw new AlreadyExistsException("Série Existente");
    }
    return repo.save(serieNova);
  }

  public List<Serie> findAll() {
    return repo.findAll();
  }

  public void delete(Integer serieId) {
    repo.findById(serieId)
        .orElseThrow(() -> new NotFoundException("Serie não encontrada"));
    repo.deleteById(serieId);
  }

  {
    // TODO Auto-generated method stub

  }

  public Serie addEpisode(Integer serieId, Episodio episodio) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Episodio> listEpisodes(Integer serieId) {
    // TODO Auto-generated method stub
    return null;
  }

  public Tempo tempoSeries() {
    // TODO Auto-generated method stub
    return null;
  }

}
