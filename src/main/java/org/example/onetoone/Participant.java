package org.example.onetoone;

import javax.persistence.*;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id",
            referencedColumnName = "id")
    private InfoReport infoReport;

    public Participant() {
    }

    public Participant(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoReport getReport() {
        return infoReport;
    }

    public void setReport(InfoReport report) {
        this.infoReport = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
