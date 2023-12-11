CREATE TABLE IF NOT EXISTS componente (
	id_componente INT PRIMARY KEY NOT NULL auto_increment,
    nome VARCHAR(40) NOT NULL,
    unidade_medida VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS registro (
	id_registro INT PRIMARY KEY NOT NULL auto_increment,
    valor DOUBLE,
    data_hora DATETIME,
    fk_componente INT NOT NULL,
    FOREIGN KEY(fk_componente) REFERENCES componente(id_componente)
);

INSERT INTO componente VALUES 
	(NULL, "CPU", "%"),
    (NULL, "MEMORIA", "GB"),
    (NULL, "DISCO", "GB");

CREATE OR REPLACE VIEW vw_registro_geral AS 
SELECT 
    componente.nome,
    registro.valor,
    componente.unidade_medida,
    registro.data_hora
FROM registro
    INNER JOIN componente ON 
        registro.fk_componente = componente.id_componente;

