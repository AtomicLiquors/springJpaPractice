package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;
    /*
    @JoinColumn
    @ManyToOne
    @Column(name="course_id")
    private int courseId;
    */
    public Review(String comment){
        this.comment = comment;
    }

    public Review(){

    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
