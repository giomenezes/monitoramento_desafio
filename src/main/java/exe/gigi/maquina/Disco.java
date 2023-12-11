package exe.gigi.maquina;

import com.github.britooo.looca.api.group.discos.Volume;
import exe.gigi.utils.Conversor;

import java.util.List;

public class Disco extends Componente {
    private List<Volume> volumes;

    public Disco(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.volumes = looca.getGrupoDeDiscos().getVolumes();
    }

    @Override
    public double getValorEmUso() {
        for (Volume volumeAtual:volumes) {
            Long volumeUso = volumeAtual.getTotal() - volumeAtual.getDisponivel();
            return Conversor.converterGB(volumeUso);
        }

        return 0;
    }

}
