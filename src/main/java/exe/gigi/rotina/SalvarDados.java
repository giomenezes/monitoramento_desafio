package exe.gigi.rotina;

import exe.gigi.conexao.Ambiente;
import exe.gigi.dao.RegistroDao;

import java.util.TimerTask;

public class SalvarDados extends TimerTask {
    @Override
    public void run() {
        RegistroDao.inserirValores(Ambiente.getBancoDeDados().listarComponentes());
    }
}
