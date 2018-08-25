package facetofront.repository;


import facetofront.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {


    /**
     * 采用内存性的存储方式   ---》》map的方式
     *
     *  考虑高并发的情况
     *
     */
    private final ConcurrentMap<Integer,User> repository =new ConcurrentHashMap<>();

    //自增长的
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user
     * @return
     */

    public boolean save(User user){
            //id从1开始
            int id = idGenerator.incrementAndGet();
            user.setId(id);
            return repository.put(id,user)==null;//保存成功
    }

    public Collection<User> findAll(){
        return  repository.values();
    }


}
