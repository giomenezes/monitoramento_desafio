package gigi.exe.dao;

import gigi.exe.maquina.Componente;
import gigi.exe.maquina.Registro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegistroDao {
    private static JdbcTemplate con;

    public RegistroDao(JdbcTemplate conexao) {
        this.con = conexao;
    }

    public static void inserirValores (Componente componente) {
//        if (con instanceof H2) {
            con.update("""
                    INSERT INTO registro VALUES (?, CURRENT_TIMESTAMP, ?);
                    """.formatted(componente.getValorEmUso(), componente.getId()));
//        } else {
//            con.update("""
//                        INSERT INTO registro VALUES (?, NOW(), ?);
//                        """.formatted(componente.getValorEmUso(), componente.getId()));
//        }
    }

    public static List<Registro> listarRegistros() {
        return con.query("""
                        SELECT * FROM registro;
                        """, new BeanPropertyRowMapper<>(Registro.class));
    }

    public static JdbcTemplate getCon() {
        return con;
    }

    public static void setCon(JdbcTemplate con) {
        RegistroDao.con = con;
    }
}
