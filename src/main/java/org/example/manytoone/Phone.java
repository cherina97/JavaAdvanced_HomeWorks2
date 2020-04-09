package org.example.manytoone;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", person=" + person +
                '}';
    }
}
