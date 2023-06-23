package com.javatar.jpaonetoone.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tutorial_datails")
public class TutorialDetails {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdOn;
    private String createdBy;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;

}
