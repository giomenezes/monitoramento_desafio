package exe.gigi.conexao.banco;

import exe.gigi.maquina.Componente;
import exe.gigi.maquina.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class Database {
    private static JdbcTemplate conexao;

    public Database() {}

    public abstract List<Componente> listarComponentes();

    public abstract List<Registro> listarRegistros();

    public abstract void inserirComponente(Componente componente);

    public abstract void inserirRegistro(Componente componente);

    public Database(JdbcTemplate conexao) {
        this.conexao = conexao;
    }

    public static JdbcTemplate getConexao() {
        return conexao;
    }

    public void setConexao(JdbcTemplate conexao) {
        this.conexao = conexao;
    }
}
