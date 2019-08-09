package by.milosh.task4;

import java.util.Collections;
import java.util.List;

public class ConcatListService {
    public void executeTwo(List<Integer> mainList, List<Integer> list) {
        mainList.addAll(list);
        Collections.sort(mainList);
    }

    public void executeMany(List<Integer> mainList, List<Integer>... lists) {
        for (List<Integer> list : lists) {
            mainList.addAll(list);
        }
        Collections.sort(mainList);
    }
}
