package exe.gigi.menu;

import exe.gigi.dao.ComponenteDao;
import exe.gigi.dao.RegistroDao;


public class Output {
    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressioneEnter() {
        System.out.println("Pressione Enter para continuar: ");
    }

    public static void exibirBanco() {
        System.out.println("""
                
                +------------------------------------------------------+
                | Escolha um banco de dados:                           |
                +------------------------------------------------------+
                | 1) MySQL (Docker)                                    |
                | 2) H2 (Local)                                        |
                |                                                      |
                | 0) Sair                                              |
                +------------------------------------------------------+   
                """);
    }

    public static void exibirMenuInicial() {
        System.out.println(
                """
                
                +------------------------------------------------------+
                | Selecione uma opção:                                 |
                +------------------------------------------------------+
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

    public static void listarInformacoes() {
        System.out.println(ComponenteDao.listarComponentes());
    }

    public static void verificarDados() {
        System.out.println(RegistroDao.listarRegistros());
    }
}
