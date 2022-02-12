//package knhel7.jd14.jpat14.task12;

import java.util.List;
import java.util.ArrayList;

public class Filter {
    protected int limit;

    public Filter(int limit) {
        this.limit = limit;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.SINGLE_INSTANCE;
        List<Integer> filtered = new ArrayList<>(source.size());
        logger.log("Start filtering!");
        for (Integer each: source) {
            if (each < limit) {
                logger.log("Element '" + each + "' doesn't pass!");
            }
            else {
                logger.log("Element '" + each + "' PASS");
                filtered.add(each);
            }
        }
        logger.log("Passed the filter " + filtered.size() +
                " elements out of " + source.size() + ".");
        return filtered;
    }
}
