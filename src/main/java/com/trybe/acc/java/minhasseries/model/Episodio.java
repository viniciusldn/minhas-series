package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer numero;

  /** The duracao em minutos. */
  private Integer duracaoEmMinutos;

  @ManyToOne
  @JoinColumn(name = "serie_id")
  private Serie serie;

  /**
   * Instantiates a new episodio.
   */
  public Episodio() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Instantiates a new episodio with 2 parameters.
   *
   * @param numero           the numero
   * @param duracaoEmMinutos the duracao em minutos
   */
  public Episodio(Integer numero, Integer duracaoEmMinutos) {
    super();
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  /**
   * Instantiates a new episodio with 4 parameters.
   *
   * @param id               the id
   * @param numero           the numero
   * @param duracaoEmMinutos the duracao em minutos
   * @param serie            the serie
   */
  public Episodio(Integer id, Integer numero, Integer duracaoEmMinutos,
      Serie serie) {
    super();
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  public Integer getId() {
    return this.id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNumero() {
    return this.numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Integer getDuracaoEmMinutos() {
    return this.duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }

}
