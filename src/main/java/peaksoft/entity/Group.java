package peaksoft.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;



@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "grup name should not be empty")
    @Size(min = 2, max = 30, message = "grup name should be between 2 and 30 characters")
    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private String dateOfStart;

    @Column(name = "date_of_finish")
    private  String dateOfFinish;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.MERGE})
    @JoinTable(name = "course_group",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    List<Course>courses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    List<Student>students;

    @Transient
    private Long courseId;
}
