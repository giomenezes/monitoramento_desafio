package gigi.exe.conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class H2 extends MySQL {
    private JdbcTemplate conexao;
    public H2() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:file:./desafio_java");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        this.conexao = new JdbcTemplate(dataSource);
    }
}
