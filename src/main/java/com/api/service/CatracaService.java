package com.api.service;

import com.api.domain.Catraca;
import com.api.repository.CatracaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class CatracaService {

    @Autowired
    private CatracaRepository catracaRepository;

    public void create(Catraca catraca){
        if (catraca != null){

            catracaRepository.save(catraca);
        }
    }

    public List<Catraca> getAll(){
        return catracaRepository.findAll();
    }

    public void update(Catraca catraca){
        if (catraca.getId() != null && catraca.getId() > 0){
            catracaRepository.saveAndFlush(catraca);
        }
    }

    public Catraca getById(Integer id){
        Catraca catraca = new Catraca();
        if (id != null && id > 0){
            catraca = catracaRepository.getOne(id);
        }
        return  catraca;
    }

    public void delete(Integer id){

        if (id != null && id > 0){
            catracaRepository.deleteById(id);
        }
    }

    public String getByQrCode(String qrCode){

        String liberado = null;

        Gson gson = new Gson();

        Catraca catraca = gson.fromJson(qrCode, Catraca.class);

        if (catraca.getQrCode() != null && catraca.getQrCode().length() > 0){
            catraca = catracaRepository.findByQrCode(catraca.getQrCode());
            if (catraca != null) {
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

