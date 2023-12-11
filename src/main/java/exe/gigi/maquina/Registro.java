package exe.gigi.maquina;

import exe.gigi.utils.Conversor;

import java.time.LocalDateTime;

public class Registro {
    private String nome;
    private String unidadeMedida;
    private Double valor;
    private LocalDateTime dataHora;

    public Registro() {
    }

    public Registro(String nome, String unidadeMedida, Double valor, LocalDateTime dataHora) {
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return """
                                
                +-----------------------------------------+
                | Registro: %s
                +-----------------------------------------+
                | Valor: %.2f %s
                | Data & Hora: %s
                +-----------------------------------------+
                """.formatted(nome, valor, unidadeMedida, Conversor.formatterDataHora.format(dataHora));
    }
}
