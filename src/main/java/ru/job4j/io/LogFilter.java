package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
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

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}