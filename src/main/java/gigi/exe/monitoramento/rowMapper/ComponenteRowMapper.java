package gigi.exe.monitoramento.rowMapper;

import gigi.exe.maquina.CPU;
import gigi.exe.maquina.Componente;
import gigi.exe.maquina.Disco;
import gigi.exe.maquina.RAM;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static gigi.exe.monitoramento.componenteEnum.ComponenteEnum.*;

public class ComponenteRowMapper implements RowMapper<Componente> {

    @Override
    public Componente mapRow(ResultSet rs, int i) throws SQLException {
        Componente componente = null;
        String nome = rs.getString("nome");

        if (nome.equals(String.valueOf(CPU))) {
            componente = new CPU(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else if (nome.equals(String.valueOf(MEMORIA))) {
            componente = new RAM(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else if (nome.equals(String.valueOf(DISCO))) {
            componente = new Disco(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("unidade_medida")
            );
        } else {
            return null;
        }
        return componente;
    }
}
