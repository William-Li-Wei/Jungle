import com.william.Horse;
import com.william.Move;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by william on 14.01.17.
 */
public class HorseTest extends TestCase {
    @Test
    public void testPossibleMoves() {
        Horse h = new Horse(true, "e4");
        Move[] moves = h.possibleMoves();

    }
}
