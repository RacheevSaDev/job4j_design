package ru.job4j.iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddBeforeFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 3));
        ListUtils.addBefore(input, 0, 1);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 2));
        ListUtils.removeIf(input, x -> x == 2);
        assertThat(input, is(Arrays.asList(0, 1)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 2));
        ListUtils.replaceIf(input, x -> x == 2, 4);
        assertThat(input, is(Arrays.asList(0, 1, 4, 4)));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6));
        List<Integer> removingElemnts = new ArrayList<>(Arrays.asList(1, 5));
        ListUtils.removeAll(input, removingElemnts);
        assertThat(input, is(Arrays.asList(2, 3, 4, 6)));
    }
}