# Desafio Java: Monitoramento de Componentes
Desafio de Java do segundo semestre de Ciência da Computação

## Objetivo:
Desenvolver um aplicativo Java para monitoramento de recursos do sistema, aderindo aos princípios SOLID e utilizando a biblioteca Looca.

## Como funciona:
O aplicativo Java está relacionado com um banco que contém os recursos do sistema que serão monitorados. Esse banco pode ser rodado tanto localmente, quanto em um container.
É preciso escolher um dos bancos ao inicializar o aplicativo. Após selecionar o banco, as capturas serão feitas automaticamente a cada 3 segundos, e você pode consultar essas capturas, ou consultar os componentes que estão sendo capturados atualmente.

## Como iniciar o aplicativo:
### Em Docker:

> [!WARNING]
> É necessário ter docker e docker compose em sua máquina!
> 
> Porta 3306 precisa estar liberada!

  1. Suba o docker compose com o comando:
```
docker compose up -d
```

  2. Interaja com o container que contém o java com o comando:
```
docker exec -it desafio_java bash
```

  3. Inicie o java com o seguinte comando:
```
java -jar monitoramento_desafio-1.1.1.jar
```

> [!CAUTION]
> Não se esqueça de derrubar o compose ao finalizar a utilização.
> ```
> docker compose down
> ```

### Localmente:

> [!WARNING]
> É necessário ter o Java 17 instalado em sua máquina!

  1. Instale o jar executável clicando [aqui](https://github.com/giomenezes/monitoramento_desafio/releases/download/1.1.1/monitoramento_desafio-1.1.1.jar):
  2. No terminal, vá para a pasta onde o jar executável salvou;
  3. Inicie o java com o seguinte comando:
```
java -jar monitoramento_desafio-1.1.1.jar
```

## Updates futuros:
***Esse projeto está em constante atualização, aqui vai uma lista de updates futuros***
  - [ ] Adicionar tabela de alertas;
  - [ ] Alertas personalizados (integração com o Slack)

Veja mais: [^1].
[^1]: Projeto similar: [monitoramento de processos](https://github.com/giomenezes/monitoramento-processos)
