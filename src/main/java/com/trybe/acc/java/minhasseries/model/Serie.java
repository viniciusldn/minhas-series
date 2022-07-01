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

  /** The episodio. */
  private ArrayList<Episodio> episodio;

  /**
   * Instantiates a new serie.
   */
  public Serie() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Contructor.
   *
   * @param id       the id
   * @param nome     the nome
   * @param episodio the episodio
   */
  public Serie(int id, String nome, ArrayList<Episodio> episodio) {
    super();
    this.id = id;
    this.nome = nome;
    this.episodio = episodio;
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
  public ArrayList<Episodio> getEpisodio() {
    return episodio;
  }

  /**
   * Sets the episodio.
   *
   * @param episodio the new episodio
   */
  public void setEpisodio(ArrayList<Episodio> episodio) {
    this.episodio = episodio;
  }

}
