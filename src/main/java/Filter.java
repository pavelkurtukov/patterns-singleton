import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int filteredCount = 0; // Кол-во прошедших фильтрацию элементов списка

        for (Integer el: source) {
            if (el < treshold) {
                logger.log("Элемент \"" + el + "\" не проходит");
                continue;
            }

            logger.log("Элемент \"" + el + "\" не проходит");
            result.add(el);
            filteredCount++;
        }

        logger.log("Прошло фильтр " + filteredCount + " элементов из " + source.size());

        return result;
    }
}
