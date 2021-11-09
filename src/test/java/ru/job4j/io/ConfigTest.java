package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Semyon Racheev"));
    }

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Semyon Racheev"));
    }

    @Test
    public void whenPairWithSpacesComment() {
        String path = "./data/pair_with_spaces.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Semyon Racheev"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKeyComment() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWithEmptyLinesComment() {
        String path = "./data/pair_with_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Semyon Racheev"));
    }
}