package exe.gigi;

import exe.gigi.rotina.SalvarDados;
import exe.gigi.menu.Menu;
import exe.gigi.rotina.Agendador;

public class Main {
    public static void main(String[] args) {
        Menu.escolherBanco();
        Agendador.executarTarefa(new SalvarDados(), 0, 3000);
        Menu.exibirMenu();
    }
}   