package com.davcott.actionLog.user;

import com.davcott.actionLog.project.Project;
import com.davcott.actionLog.task.Task;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String userName;

    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Project> ownedProjects;

    @ManyToMany
    private List<Project> memberOfProjects; //need setter, getter

    @Column(name="created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createdDate;

    @OneToMany(mappedBy = "owner")
    private List<Task> tasksOwned;

    @OneToMany(mappedBy = "creator")
    private List<Task> tasksCreated;

    @Override
    public String toString() {
        return String.format("customer [id=%d, username='%s', email='%s']", id, userName, email);
    }

}
