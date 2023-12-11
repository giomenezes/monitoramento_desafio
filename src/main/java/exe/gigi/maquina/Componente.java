package exe.gigi.maquina;

import com.github.britooo.looca.api.core.Looca;

public abstract class Componente {
    private Integer id_componente;
    private String nome;
    private String unidade_medida;
    protected Looca looca;

    public Componente(Integer id_componente, String nome, String unidade_medida) {
        this.id_componente = id_componente;
        this.nome = nome;
        this.unidade_medida = unidade_medida;
        this.looca = new Looca();
    }

    public abstract double getValorEmUso();

    public Integer getIdComponente() {
        return id_componente;
    }

    public void setIdComponente(Integer id) {
        this.id_componente = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    @Override
    public String toString() {
        return """
                
                +-----------------------------------------+
                | Componente                              |
                +-----------------------------------------+
                | ID: %d
                | Nome: %s
                | Unidade medida: %s
                +-----------------------------------------+
                """.formatted(id_componente, nome, unidade_medida);
    }
}
