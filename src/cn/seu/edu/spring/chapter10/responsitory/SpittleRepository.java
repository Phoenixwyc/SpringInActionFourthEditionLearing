package cn.seu.edu.spring.chapter10.responsitory;

import cn.seu.edu.spring.chapter10.domain.Spittle;

import java.util.List;
/**
 * Created by Administrator on 2017/9/18.
 */
public interface SpittleRepository {
    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);
}
