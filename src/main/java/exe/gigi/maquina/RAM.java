package exe.gigi.maquina;

import com.github.britooo.looca.api.group.memoria.Memoria;
import exe.gigi.utils.Conversor;

public class RAM extends Componente {
    private Memoria memoria;
    private Integer limite_medio;
    private Integer limite_maximo;

    public RAM(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.memoria = looca.getMemoria();
    }

    @Override
    public double getValorEmUso() {
        return Conversor.converterGB(memoria.getEmUso());
    }

    @Override
    public Integer alertarAtencao() {
        return 60;
    }

    @Override
    public Integer alertarUrgencia() {
        return 80;
    }
}
