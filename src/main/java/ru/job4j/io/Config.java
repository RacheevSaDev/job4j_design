package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {
    private static final Pattern PAIR_TEMPLATE = Pattern.compile("^(.+)(=)(.*)$");
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (line.startsWith("#") || line.equals("")) {
                    continue;
                }
                Matcher m = PAIR_TEMPLATE.matcher(line);
                if (!m.matches()) {
                    throw(new IllegalArgumentException("Строка " + "\""
                            + line + "\"" + " не соответствует шаблону \"<ключ> = [значение]\""));
                }
                String[] lineParsed = line.split("=");
                values.put(lineParsed[0].trim(), lineParsed[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
