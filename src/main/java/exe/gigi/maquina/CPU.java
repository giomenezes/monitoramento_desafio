package exe.gigi.maquina;

import com.github.britooo.looca.api.group.processador.Processador;

public class CPU extends Componente {
    private Processador cpu;

    public CPU(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.cpu = looca.getProcessador();
    }

    @Override
    public double getValorEmUso() {
        return cpu.getUso() ;
    }
}
