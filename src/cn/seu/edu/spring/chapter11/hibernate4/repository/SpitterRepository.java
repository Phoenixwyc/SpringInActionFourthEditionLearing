package cn.seu.edu.spring.chapter11.hibernate4.repository;

import cn.seu.edu.spring.chapter11.hibernate4.domain.Spitter;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}
