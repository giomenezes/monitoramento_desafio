package exe.gigi.conexao.banco;

import exe.gigi.dao.ComponenteDao;
import exe.gigi.maquina.CPU;
import exe.gigi.maquina.Componente;
import exe.gigi.maquina.RAM;
import exe.gigi.maquina.Registro;
import exe.gigi.maquina.*;
import exe.gigi.monitoramento.rowMapper.ComponenteRowMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class H2 extends Database {
    public H2() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:file:./desafiojava");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        setConexao(new JdbcTemplate(dataSource));
    }

    public static void criarBanco() {
        getConexao().execute("DROP VIEW IF EXISTS vw_registro_geral");
        getConexao().execute("DROP TABLE IF EXISTS registro");
        getConexao().execute("DROP TABLE IF EXISTS componente");

        getConexao().execute("""
                CREATE TABLE componente (
                	id_componente INT PRIMARY KEY not null auto_increment,
                    nome VARCHAR(40) NOT NULL,
                    unidade_medida VARCHAR(15) NOT NULL
                );
        """);

        getConexao().execute("""
                CREATE TABLE registro (
                	id_registro INT PRIMARY KEY not null auto_increment,
                    valor DOUBLE,
                    data_hora DATETIME,
                    fk_componente INT NOT NULL,
                    FOREIGN KEY(fk_componente) REFERENCES componente(id_componente)
                );
        """);

        getConexao().execute("""
                CREATE OR REPLACE VIEW vw_registro_geral AS
                SELECT
                    componente.nome AS nome,
                    registro.valor AS valor,
                    componente.unidade_medida AS unidade_medida,
                    registro.data_hora AS dataHora
                FROM registro
                    INNER JOIN componente ON
                        registro.fk_componente = componente.id_componente;
        """);

        ComponenteDao.inserirComponente(new CPU(null, "CPU", "%"));
        ComponenteDao.inserirComponente(new RAM(null, "MEMORIA", "GB"));
        ComponenteDao.inserirComponente(new Disco(null, "DISCO", "GB"));
    }

    @Override
    public List<Componente> listarComponentes() {
        return getConexao().query("""
                SELECT * FROM componente;
                """, new ComponenteRowMapper());
    }

    @Override
    public List<Registro> listarRegistros() {
        return getConexao().query("""
                SELECT * FROM vw_registro_geral;
                """, new BeanPropertyRowMapper<>(Registro.class));
    }

    @Override
    public void inserirComponente(Componente componente) {
        getConexao().update("""
            INSERT INTO componente(nome, unidade_medida) VALUES (?, ?);
        """, componente.getNome(), componente.getUnidade_medida());
    }

    @Override
    public void inserirRegistro(Componente componente) {
        getConexao().update("""
            INSERT INTO registro(valor, data_hora, fk_componente) VALUES (?, CURRENT_TIMESTAMP, ?);
        """, componente.getValorEmUso(), componente.getIdComponente());
    }
}
