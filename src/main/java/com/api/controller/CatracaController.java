package com.api.controller;

import com.api.service.CatracaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CatracaController {

    @Autowired
    private CatracaService catracaService;

    @GetMapping("catraca/qrcode")
    public String getByQrCode(@RequestBody String qrCode) {
        return catracaService.getByQrCode(qrCode);
    }
}
