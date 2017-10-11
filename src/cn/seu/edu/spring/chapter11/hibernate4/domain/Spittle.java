package cn.seu.edu.spring.chapter11.hibernate4.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/20.
 */
@Entity
public class Spittle {

    private Spittle() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spitter")
    private Spitter spitter;

    @Column(name = "message")
    private String message;

    @Column
    private Date postedTime;

    public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getPostedTime() {
        return this.postedTime;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }
}
