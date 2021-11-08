package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> filteredLines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = in.lines().collect(Collectors.toList());
            for (String line : lines) {
                String[] splitLine = line.split(" ");
                if ("404".equals(splitLine[splitLine.length - 2])) {
                    filteredLines.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredLines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str: log) {
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}