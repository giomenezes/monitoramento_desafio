package exe.gigi.dao;

import exe.gigi.conexao.Ambiente;
import exe.gigi.maquina.Componente;
import exe.gigi.maquina.Registro;

import java.util.List;

public class RegistroDao {
    public static void inserirValores (List<Componente> componentes) {
        for (Componente componenteAtual:componentes) {
            Ambiente.getBancoDeDados().inserirRegistro(componenteAtual);
        }
    }

    public static List<Registro> listarRegistros() {
        return Ambiente.getBancoDeDados().listarRegistros();
    }
}
