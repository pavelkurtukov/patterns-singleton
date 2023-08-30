import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите размер списка: ");
            int n = Integer.parseInt(reader.readLine());

            System.out.print("Введите верхнюю границу для значений: ");
            int m = Integer.parseInt(reader.readLine());

            List<Integer> arrayList = generateArrayList(n, m);

            logger.log("Выводим список на экран");
            System.out.print("Полученный случайный список: ");
            printArrayList(arrayList);

            System.out.print("Введите порог для фильтра: ");
            int f = Integer.parseInt(reader.readLine());

            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(f);
            List<Integer> filteredArrayList = filter.filterOut(arrayList);

            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список: ");
            printArrayList(filteredArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.log("Завершаем программу");
    }

    // Вывод на экран элементов списка
    public static void printArrayList(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arrayList.get(i));
        }
        System.out.println();
    }

    // Генерация списка из n элементом со значениями от 1 до m
    public static List<Integer> generateArrayList(int n, int m) {
        Logger logger = Logger.getInstance();
        logger.log("Создаём и наполняем список");

        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arrayList.add(random.nextInt(m + 1));
        }

        return arrayList;
    }
}
