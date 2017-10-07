package by.it.matusevich.jd01_03;

import java.util.Arrays;
import java.util.Collections;

public class Utils {


    public static double getMax(Double[] doubles) {
        return Collections.max(Arrays.asList(doubles));

    }

    public static double getMin(Double[] doubles) {
        return Collections.min(Arrays.asList(doubles));
    }
}
