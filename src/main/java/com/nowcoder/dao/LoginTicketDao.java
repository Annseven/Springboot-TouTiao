package com.nowcoder.dao;

import com.nowcoder.model.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: AnNing
 * @Description:
 * @Date: Create in 14:25 2019/3/1
 */
@Repository
@Mapper
public interface LoginTicketDao {

    String TABLE_NAME="LoginTicket";
    String INSERT_FIELDS="UserId,Ticket,Expired,Status";
    String SELECT_FIELDS="id,"+ INSERT_FIELDS;

    @Insert({"insert into" ,TABLE_NAME,"(",INSERT_FIELDS,
            ") values (#{UserId},#{Ticket},#{Expired},#{Status})"})
    int addTicket(LoginTicket ticket);

    @Select({"select", SELECT_FIELDS,"from",TABLE_NAME,"where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"update",TABLE_NAME,"set status=#{status} where ticket=#{ticket}"})
    void updateStatus(@Param("ticket") String ticket,@Param("status") int status);

}
