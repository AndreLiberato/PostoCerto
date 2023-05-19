package com.ufrn.pds.postocerto.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.MudancaPreco;
import com.ufrn.pds.postocerto.model.Posto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MudancaPrecoDTO {

    @NotNull(message = "o campo 'posto' não pode ser nulo.")
    private Posto posto;
    
    @NotNull(message = "o campo 'combustível' não pode ser nulo.")
    private Combustivel combustivel;

    @NotNull(message = "O campo 'valor' não pode estar nulo.")
    private double valor;

    @NotBlank(message = "O campo 'data' não pode estar em branco.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataHora;

    public MudancaPrecoDTO() {
        // Construtor vazio
    }

    public MudancaPrecoDTO(Long id, double valor, LocalDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public MudancaPrecoDTO(MudancaPreco mudancaPreco) {
        valor = mudancaPreco.getValor();
        dataHora = mudancaPreco.getDataHora();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
