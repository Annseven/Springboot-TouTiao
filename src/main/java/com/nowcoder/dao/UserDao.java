package com.nowcoder.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 18:16 2019/2/18
 */
@Mapper
@Repository
public interface UserDao {
    String TABLE_NAME = "User";
    String INSET_FIELDS = "name, password, salt, head_url ";
    String SELECT_FIELDS = "id, name, password, salt, head_url";

    @Insert({"insert into" ,TABLE_NAME,"(",INSET_FIELDS,
    ") values (#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id=#{id}"})
    User selectById(int id);

    @Update({"update",TABLE_NAME,"set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ",TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);

    @Select("select * from user where name=#{name} and password=#{password}")
    User findByUsernameAndPassword(@Param("name") String name, @Param("password") String password);


    @Select({"select * from ",TABLE_NAME,"where name=#{name}"})
    User findByUsername(@Param("name") String name);

}
