package exe.gigi.conexao.banco;

import exe.gigi.maquina.Componente;
import exe.gigi.maquina.Registro;
import exe.gigi.monitoramento.rowMapper.ComponenteRowMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MySQL extends Database {

    public MySQL() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql:3306/desafio_java");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");

        setConexao(new JdbcTemplate(dataSource));
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
            INSERT INTO registro(valor, data_hora, fk_componente) VALUES (?, NOW(), ?);
        """, componente.getValorEmUso(), componente.getIdComponente());
    }
}
