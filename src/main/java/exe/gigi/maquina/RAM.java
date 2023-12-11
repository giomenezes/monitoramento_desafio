package exe.gigi.maquina;

import com.github.britooo.looca.api.group.memoria.Memoria;
import exe.gigi.utils.Conversor;

public class RAM extends Componente {
    private Memoria memoria;

    public RAM(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.memoria = looca.getMemoria();
    }

    @Override
    public double getValorEmUso() {
        return Conversor.converterGB(memoria.getEmUso());
    }

}
