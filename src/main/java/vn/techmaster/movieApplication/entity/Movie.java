package vn.techmaster.movieApplication.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.movieApplication.model.enums.MovieType;

import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String slug;

    @Column(columnDefinition = "TEXT")
    String description;

    String poster;
    Integer releaseYear;
    Integer view;
    Double rating;

    @Enumerated(EnumType.STRING)
    MovieType type;

    Boolean status;
    Date createdAt;
    Date updatedAt;
    Date publishedAt;
}
