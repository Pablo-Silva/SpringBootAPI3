package com.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Catraca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String qrCode;

    private Integer onibus_id;

    private Integer terminal_id;

    private Integer tubo_id;

    public Catraca() {
    }

    public Catraca(String qrCode, Integer onibus_id, Integer terminal_id, Integer tubo_id) {
        this.qrCode = qrCode;
        this.onibus_id = onibus_id;
        this.terminal_id = terminal_id;
        this.tubo_id = tubo_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getOnibus_id() {
        return onibus_id;
    }

    public void setOnibus_id(Integer onibus_id) {
        this.onibus_id = onibus_id;
    }

    public Integer getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(Integer terminal_id) {
        this.terminal_id = terminal_id;
    }

    public Integer getTubo_id() {
        return tubo_id;
    }

    public void setTubo_id(Integer tubo_id) {
        this.tubo_id = tubo_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catraca catraca = (Catraca) o;
        return id.equals(catraca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Catraca{" +
                "id=" + id +
                ", qrCode='" + qrCode + '\'' +
                ", onibus_id=" + onibus_id +
                ", terminal_id=" + terminal_id +
                ", tubo_id=" + tubo_id +
                '}';
    }
}

