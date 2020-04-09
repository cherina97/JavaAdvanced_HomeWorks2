package org.example.onetoone;

import javax.persistence.*;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Table(name = "infoReports")
public class InfoReport {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String title;

    @OneToOne(mappedBy = "infoReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Participant participant;

    public InfoReport() {
    }

    public InfoReport(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoReport report = (InfoReport) o;
        return getId() == report.getId() &&
                Objects.equals(getTitle(), report.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
