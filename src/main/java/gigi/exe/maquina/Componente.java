package gigi.exe.maquina;

import com.github.britooo.looca.api.core.Looca;
import gigi.exe.alertas.Alertavel;

public abstract class Componente implements Alertavel {
    private Integer id;
    private String nome;
    private String unidade_medida;
    protected Looca looca;

    public Componente(Integer id, String nome, String unidade_medida) {
        this.id = id;
        this.nome = nome;
        this.unidade_medida = unidade_medida;
        this.looca = new Looca();
    }

    public abstract double getValorEmUso();

    @Override
    public abstract Integer alertarAtencao();

    @Override
    public abstract Integer alertarUrgencia();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                """.formatted(id, nome, unidade_medida);
    }
}
