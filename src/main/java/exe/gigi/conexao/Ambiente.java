package exe.gigi.conexao;

import exe.gigi.conexao.banco.Database;
import exe.gigi.maquina.Componente;

import java.util.List;

public class Ambiente {
    private static Database bancoDeDados;
    private static List<Componente> componentes;

    public static List<Componente> getComponentes() {
        return componentes;
    }

    public static void setComponentes() {
        Ambiente.componentes = bancoDeDados.listarComponentes();
    }

    public static Database getBancoDeDados() {
        return bancoDeDados;
    }

    public static void setBancoDeDados(Database bancoDeDados) {
        Ambiente.bancoDeDados = bancoDeDados;
    }
}
