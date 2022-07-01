package com.trybe.acc.java.minhasseries.controller;

import java.util.List;

import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SerieController {

  @Autowired
  private SerieService service;

  @GetMapping("/series")
  public List<Serie> getSeries() {
    return service.findAll();
  }

}
