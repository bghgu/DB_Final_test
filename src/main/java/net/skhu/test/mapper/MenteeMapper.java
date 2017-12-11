package net.skhu.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ds on 2017-12-10.
 */
@Mapper
public interface MenteeMapper {
    int findByIdAndMid(@Param("id") int id, @Param("m_id") int m_id);
}
