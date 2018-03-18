package chapter4.exercises.e4_7;

import common.Function;
import org.junit.Test;

import java.util.List;

import static common.CollectionUtilities.list;
import static org.junit.Assert.assertEquals;

public class Exercise4_7Test {
    Function<String, String> f1 = x -> "(a" + x + ")";
    Function<String, String> f2 = x -> "{b" + x + "}";
    Function<String, String> f3 = x -> "[c" + x + "]";
    List<Function<String, String>> list = list(f1, f2, f3);

    @Test
    public void testComposeAllLeft() {
        assertEquals("(a{b[cx]})", Exercise4_7.composeAllViaFoldLeft(list).apply("x"));
    }

}