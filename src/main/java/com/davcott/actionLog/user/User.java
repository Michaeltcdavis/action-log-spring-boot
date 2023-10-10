package com.davcott.actionLog.user;

import com.davcott.actionLog.project.Project;
import com.davcott.actionLog.task.Task;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @OneToMany(mappedBy = "owner")
    private List<Task> tasksOwned;

    @OneToMany(mappedBy = "creator")
    private List<Task> tasksCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Project> getOwnedProjects() {
        return ownedProjects;
    }

    public void setOwnedProjects(List<Project> ownedProjects) {
        this.ownedProjects = ownedProjects;
    }

    public List<Project> getMemberOfProjects() {
        return memberOfProjects;
    }

    public void setMemberOfProjects(List<Project> memberOfProjects) {
        this.memberOfProjects = memberOfProjects;
    }

    public List<Task> getTasksOwned() {
        return tasksOwned;
    }

    public void setTasksOwned(List<Task> tasksOwned) {
        this.tasksOwned = tasksOwned;
    }

    public List<Task> getTasksCreated() {
        return tasksCreated;
    }

    public void setTasksCreated(List<Task> tasksCreated) {
        this.tasksCreated = tasksCreated;
    }
}
