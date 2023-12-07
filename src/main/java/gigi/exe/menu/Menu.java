package gigi.exe.menu;

import gigi.exe.maquina.Componente;

public class Menu {
    public void exibirMenu() {
        do {
            Opcoes.limparConsole();
            Opcoes.exibirMenuInicial();
            switch (Input.solicitarOpcaoInt()) {
                case 1 -> Opcoes.listarInformacoes();
                case 2 -> Opcoes.verificarDados();
                case 0 -> Opcoes.exibirMensagemSair();
                default -> Opcoes.opcaoInvalida();
            }
        } while(true);
    }
}
