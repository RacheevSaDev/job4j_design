package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 34;
        char gender = 'M';
        boolean isGraduated = true;
        double growth = 1.7687;
        byte something = 8;
        short number = 32;
        long distantion = 324567889;
        float alt = 3.4E+3F;
        LOG.debug("Info : age : {}, gender : {}, isGraduated : {}, growth : {}, "
                        + "something : {}, number : {}, distantion : {}, distantion : {},",
                age, gender, isGraduated, growth, something, number, distantion, alt);
    }
}