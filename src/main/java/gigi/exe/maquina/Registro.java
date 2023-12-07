package gigi.exe.maquina;

public class Registro {
    private Integer id;
    private Double valor;
    private Integer fk_componente;

    public Registro(Integer id, Double valor, Integer fk_componente) {
        this.id = id;
        this.valor = valor;
        this.fk_componente = fk_componente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getFk_componente() {
        return fk_componente;
    }

    public void setFk_componente(Integer fk_componente) {
        this.fk_componente = fk_componente;
    }

    @Override
    public String toString() {
        return """
                                
                +-----------------------------------------+
                | Registro: %d
                +-----------------------------------------+
                | ID Componente: %d                                 
                | Valor: %f
                +-----------------------------------------+
                """.formatted(id, fk_componente, valor);
    }
}
