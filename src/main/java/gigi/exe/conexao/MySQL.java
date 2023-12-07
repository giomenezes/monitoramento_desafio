package gigi.exe.conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQL {
    private JdbcTemplate conexao;

    public MySQL() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql:3306/desafio_java");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");

        this.conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexao() {
        return conexao;
    }
}
