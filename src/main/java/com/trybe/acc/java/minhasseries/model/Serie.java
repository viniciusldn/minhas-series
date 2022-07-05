package com.trybe.acc.java.minhasseries.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Serie.
 */
@Entity
public class Serie {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  /** The nome. */
  private String nome;

  /** The episodios. */
  private ArrayList<Episodio> episodios;

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
   * Instantiates a new serie.
   *
   * @param id        the id
   * @param nome      the nome
   * @param episodios the episodios
   */
  public Serie(int id, String nome, ArrayList<Episodio> episodios) {
    super();
    this.id = id;
    this.nome = nome;
    this.episodios = episodios;
  }

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
    return id;
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
    return nome;
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
  public ArrayList<Episodio> getEpisodios() {
    return this.episodios;
  }

  /**
   * Sets the episodio.
   *
   * @param episodios the new episodios
   */
  public void setEpisodios(ArrayList<Episodio> episodios) {
    this.episodios = episodios;
  }

  public void adicionarEpisodio(Episodio episodio) {
    this.episodios.add(episodio);
  }

}
