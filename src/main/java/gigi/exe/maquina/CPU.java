package gigi.exe.maquina;

import com.github.britooo.looca.api.group.processador.Processador;

public class CPU extends Componente {
    private Processador cpu;
    private Integer limite_medio;
    private Integer limite_maximo;

    public CPU(Integer id, String nome, String unidade_medida) {
        super(id, nome, unidade_medida);
        this.cpu = looca.getProcessador();
    }

    @Override
    public double getValorEmUso() {
        return cpu.getUso();
    }

    @Override
    public Integer alertarAtencao() {
        return 50;
    }

    @Override
    public Integer alertarUrgencia() {
        return 75;
    }

    @Override
    public String toString() {
        return """
                
                +-----------------------------------------+
                | CPU                                     |
                +-----------------------------------------+
                | Uso atual: %f                                  
                +-----------------------------------------+
                """.formatted(this.getValorEmUso());
    }
}
