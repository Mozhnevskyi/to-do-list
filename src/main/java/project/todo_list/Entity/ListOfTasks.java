package project.todo_list.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "lists")
public class ListOfTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    @Setter(AccessLevel.NONE)
    private int listId;
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "list_type")
    private ListType listType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "list")
    private List<Task> tasks;

    @OneToMany(mappedBy = "list")
    private List<Comment> comments;
}
