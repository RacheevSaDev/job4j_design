package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private String email;
    @XmlElement
    private String address;

    public Contact() {
    }

    public Contact(String phone, String email, String address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" + "phone='" + phone + '\'' + ", email='"
                + email + '\'' + ", address='" + address + '\'' + '}';
    }
}
