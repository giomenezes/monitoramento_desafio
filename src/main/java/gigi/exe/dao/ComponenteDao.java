package gigi.exe.dao;

import gigi.exe.maquina.Componente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ComponenteDao {
    private static JdbcTemplate con;
    private static List<Componente> componentes;

    public ComponenteDao(JdbcTemplate conexao) {
        this.con = conexao;
        this.componentes = new ArrayList<>();
    }


}
