package cn.seu.edu.spring.chapter10.responsitory;

import cn.seu.edu.spring.chapter10.domain.Spitter;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
