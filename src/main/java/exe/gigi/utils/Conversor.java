package exe.gigi.utils;

import java.time.format.DateTimeFormatter;

public class Conversor {
    public static double converterGB (Long bytes) { return bytes / Math.pow(1024, 3); }

    public static DateTimeFormatter formatterDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
}
