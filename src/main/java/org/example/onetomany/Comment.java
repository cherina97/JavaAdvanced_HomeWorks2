package org.example.onetomany;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String authorName) {
        this.authorName = authorName;
    }

    public Comment() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() &&
                Objects.equals(getAuthorName(), comment.getAuthorName()) &&
                Objects.equals(getPost(), comment.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthorName(), getPost());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
