package com.davcott.actionLog.task;

import com.davcott.actionLog.project.Project;
import com.davcott.actionLog.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date targetDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private TaskStatus status;

    private String comments;

    @Temporal(TemporalType.DATE)
    private Date timeStart;

    @Temporal(TemporalType.DATE)
    private Date timeComplete;

}
