package gigi.exe.menu;

import gigi.exe.maquina.Componente;

public class Opcoes {
    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void exibirMenuInicial() {
        System.out.println(
                """
                
                +------------------------------------------------------+
                | Selecione uma opção:                                 |
                |                                                      |
                | 1) Listar componentes                                |
                | 2) Verificar uso de componentes                      |
                |                                                      |
                | 0) Sair                                              |
                +------------------------------------------------------+                
                """
        );
    }

    public static void exibirMensagemSair() {
        System.out.println("Saindo... ");
        System.exit(0);
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida");
    }

    public static void listarInformacoes() {}

    public static void verificarDados() {}
}
