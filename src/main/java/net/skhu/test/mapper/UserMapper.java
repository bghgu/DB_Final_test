package net.skhu.test.mapper;

import net.skhu.test.dto.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ds on 2017-12-09.
 */
@Mapper
public interface UserMapper {
    //로그인
    User findByUid(String u_id);
}
