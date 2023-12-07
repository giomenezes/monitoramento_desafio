package gigi.exe.maquina;

import com.github.britooo.looca.api.group.discos.Volume;

import java.util.List;

public class Disco extends Componente {
    private List<Volume> volumes;
    private Integer limite_medio;
    private Integer limite_maximo;


    public Disco(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.volumes = looca.getGrupoDeDiscos().getVolumes();
    }

    @Override
    public double getValorEmUso() {
        for (Volume volumeAtual:volumes) {
            return volumeAtual.getDisponivel() - volumeAtual.getTotal();
        }

        return 0;
    }

    @Override
    public Integer alertarAtencao() {
        return 65;
    }

    @Override
    public Integer alertarUrgencia() {
        return 85;
    }

    @Override
    public String toString() {
        return """
                                
                +-----------------------------------------+
                | Disco                                   |
                +-----------------------------------------+
                | Uso atual: %f                                  
                +-----------------------------------------+
                """.formatted(this.getValorEmUso());
    }
}
