package com.trybe.acc.java.minhasseries.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Serie.
 */
@Entity
public class Serie {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  /** The nome. */
  private String nome;

  /** The episodios. */
  @OneToMany(mappedBy = "serie", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<Episodio> episodios;

  /**
   * Instantiates a new serie.
   */
  public Serie() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Instantiates a new serie.
   *
   * @param nome the nome
   */
  public Serie(String nome) {
    super();
    this.nome = nome;
  }

  /**
   * Tempo total.
   *
   * @return the integer
   */
  public Integer tempoTotal() {
    return episodios.stream().map(Episodio::getDuracaoEmMinutos).reduce(0,
        (total, minutos) -> total + minutos);
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return this.id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the nome.
   *
   * @return the nome
   */
  public String getNome() {
    return this.nome;
  }

  /**
   * Sets the nome.
   *
   * @param nome the new nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Gets the episodio.
   *
   * @return the episodio
   */
  public List<Episodio> getEpisodios() {
    return this.episodios;
  }

  /**
   * Adicionar episodio.
   *
   * @param episodio the episodio
   */
  public void adicionarEpisodio(Episodio episodio) {
    this.episodios.add(episodio);
  }

  /**
   * Remover episodio.
   *
   * @param episodioId the episodio id
   */
  public void removerEpisodio(int episodioId) {
    episodios.remove(episodioId);
  }

}
