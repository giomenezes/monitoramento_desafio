package exe.gigi.monitoramento.rowMapper;

import exe.gigi.maquina.CPU;
import exe.gigi.maquina.Componente;
import exe.gigi.maquina.Disco;
import exe.gigi.maquina.RAM;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static exe.gigi.monitoramento.componenteEnum.ComponenteEnum.*;

public class ComponenteRowMapper implements RowMapper<Componente> {
    @Override
    public Componente mapRow(ResultSet rs, int i) throws SQLException {
        Componente componente;
        String nome = rs.getString("nome");

        if (nome.equals(String.valueOf(CPU))) {
            componente = new CPU(
                    rs.getInt("id_componente"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else if (nome.equals(String.valueOf(MEMORIA))) {
            componente = new RAM(
                    rs.getInt("id_componente"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else if (nome.equals(String.valueOf(DISCO))) {
            componente = new Disco(
                    rs.getInt("id_componente"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else {
            return null;
        }
        return componente;
    }
}
