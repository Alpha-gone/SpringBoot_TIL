package com.example.jpatutorial.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "schooldb")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1,
            schema = "schooldb")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId",
            foreignKey = @ForeignKey(name = "fk_course_id"))
    @ToString.Exclude
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseMaterial that = (CourseMaterial) o;
        return courseMaterialId != null && Objects.equals(courseMaterialId, that.courseMaterialId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
