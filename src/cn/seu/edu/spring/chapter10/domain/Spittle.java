package cn.seu.edu.spring.chapter10.domain;
import cn.seu.edu.spring.chapter10.domain.Spitter;

import java.util.Date;
/**
 * Created by Administrator on 2017/9/18.
 */
public class Spittle {
    private final Long id;
    private final Spitter spitter;
    private final String message;
    private final Date postedTime;

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
