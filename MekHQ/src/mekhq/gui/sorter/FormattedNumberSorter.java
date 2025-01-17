package mekhq.gui.sorter;

import org.apache.logging.log4j.LogManager;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Comparator;

/**
 * A comparator for numbers that have been formatted with DecimalFormat
 * @author Jay Lawson
 */
public class FormattedNumberSorter implements Comparator<String>, Serializable {
    private static final long serialVersionUID = -7891209454957499554L;
    private static final String PLUS_SIGN = "+";
    private static final DecimalFormat FORMAT = new DecimalFormat();

    @Override
    public int compare(String s0, String s1) {
        // Cut off leading "+" sign if there
        if (s0.startsWith(PLUS_SIGN)) {
            s0 = s0.substring(1);
        }
        if (s1.startsWith(PLUS_SIGN)) {
            s1 = s1.substring(1);
        }
        // Empty cells are smaller than all numbers
        if ((s0.length() == 0) && (s1.length() == 0)) {
            return 0;
        }
        if (s0.length() == 0) {
            return -1;
        }
        if (s1.length() == 0) {
            return 1;
        }
        //lets find the weight class integer for each name
        long l0 = 0;
        try {
            l0 = FORMAT.parse(s0).longValue();
        } catch (ParseException e) {
            LogManager.getLogger().error("", e);
        }
        long l1 = 0;
        try {
            l1 = FORMAT.parse(s1).longValue();
        } catch (ParseException e) {
            LogManager.getLogger().error("", e);
        }
        return Long.compare(l0, l1);
    }
}
