package project.todo_list.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskId")
    @Setter(AccessLevel.NONE)
    private int taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "decription")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIME)
    @Column(name = "deadline")
    private Date deadline;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "list_id",nullable = false)
    private ListOfTasks list;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
}
