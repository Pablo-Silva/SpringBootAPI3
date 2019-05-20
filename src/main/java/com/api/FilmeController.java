package com.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class FilmeController {

	@Autowired
    private FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public FilmeController() {
    }

    @GetMapping("/filmes")
    public List<Filme> getFilmes() {
        return (List<Filme>) filmeRepository.findAll();
    }

    @PostMapping("/filmes")
    public void addUser(@RequestBody Filme filme) {
        filmeRepository.save(filme);
    }

}