package exe.gigi.monitoramento.componenteEnum;

public enum ComponenteEnum {
    CPU,
    MEMORIA,
    DISCO;

    public static ComponenteEnum of(int codigo) {
        switch (codigo) {
            case 1: return CPU;
            case 2: return MEMORIA;
            case 3: return DISCO;
        }
        return null;
    }

}
