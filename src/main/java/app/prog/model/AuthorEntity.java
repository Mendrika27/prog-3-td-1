package app.prog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String paricularity;
    @OneToMany(mappedBy = "author")
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private BookEntity book;

    public boolean hasParticularity() {
        return paricularity != null;
    }

}
