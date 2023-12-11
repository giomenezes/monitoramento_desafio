package exe.gigi.dao;

import exe.gigi.conexao.Ambiente;
import exe.gigi.maquina.Componente;

import java.util.List;

public class ComponenteDao {
    public static List<Componente> listarComponentes() {
        return Ambiente.getBancoDeDados().listarComponentes();
    }

    public static void inserirComponente(Componente componente) {
        Ambiente.getBancoDeDados().inserirComponente(componente);
    }
}


