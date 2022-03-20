package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "bank")
public class Bank {
    @XmlAttribute
    private boolean isActive;
    @XmlAttribute
    private String bic;
    @XmlAttribute
    private int filial;

    @XmlElement
    private Contact contact;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private Department[] departments;

    public Bank() {
    }

    public Bank(boolean isActive, String bic, int filial,
                Contact contact, Department[] departments) {
        this.isActive = isActive;
        this.bic = bic;
        this.filial = filial;
        this.contact = contact;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Bank{" + "isActive=" + isActive + ", bic='" + bic + '\'' + ", filial=" + filial
                + ", contact=" + contact + ", departments=" + Arrays.toString(departments) + '}';
    }
}
