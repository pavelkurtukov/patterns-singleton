import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;

    public void log(String msg) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        System.out.printf("[%s #%d] %s\n", currentTime, num++, msg);
    }

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {}

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        return logger == null ? new Logger() : logger;
    }
}