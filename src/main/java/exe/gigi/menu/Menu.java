package exe.gigi.menu;

import exe.gigi.conexao.banco.H2;
import exe.gigi.conexao.banco.MySQL;
import exe.gigi.conexao.Ambiente;

public class Menu {
    public static void escolherBanco() {
        do {
            Output.exibirBanco();
            Integer escolha = Input.solicitarOpcaoInt();

            switch (escolha) {
                case 1:
                    Ambiente.setBancoDeDados(new MySQL());
                    break;
                case 2:
                    Ambiente.setBancoDeDados(new H2());
                    H2.criarBanco();
                    break;
                case 0:
                    Output.exibirMensagemSair();
                    break;
                default:
                    Output.opcaoInvalida();
                    break;
            }
        } while(Ambiente.getBancoDeDados() == null);
    }

    public static void exibirMenu() {
        do {
            Output.limparConsole();
            Output.exibirMenuInicial();
            switch (Input.solicitarOpcaoInt()) {
                case 1 -> Output.listarInformacoes();
                case 2 -> Output.verificarDados();
                case 0 -> Output.exibirMensagemSair();
                default -> Output.opcaoInvalida();
            }
            Menu.pressioneEnter();
        } while(true);
    }

    public static void pressioneEnter() {
        Output.pressioneEnter();
        Input.solicitarOpcaoString();
    }
}
