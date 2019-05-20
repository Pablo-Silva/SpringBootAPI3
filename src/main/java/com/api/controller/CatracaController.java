package com.api.controller;

import com.api.FilmeRepository;
import com.api.domain.Catraca;
import com.api.repository.CatracaRepository;
import com.api.service.CatracaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CatracaController {

    @Autowired
    private CatracaRepository catracaRepository;

    public CatracaController(CatracaRepository catracaRepository) {
        this.catracaRepository = catracaRepository;
    }

    public CatracaController() {
    }

    @GetMapping("/catraca/qrcode")
    public String getByQrCode(@RequestBody Catraca catraca) {
        String liberado = null;

        //Gson gson = new Gson();

        //Catraca catraca = gson.fromJson(qrCode, Catraca.class);

        if (catraca.getQrCode() != null && catraca.getQrCode().length() > 0){
            Catraca catracaAux = catracaRepository.findByQrCode(catraca.getQrCode());
            if (catracaAux != null) {
                liberado = "Sucesso";
            } else{
                liberado = "Falhou";
            }
        }

        else{
            liberado = "Falhou";
        }
        
        return liberado;
    }
}

