package com.api.repository;


import com.api.domain.Catraca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface CatracaRepository extends JpaRepository<Catraca, Integer> {

    Catraca findByQrCode(String qrCode);
}
