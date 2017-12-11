package net.skhu.test.mapper;

import net.skhu.test.dto.Mentee;
import net.skhu.test.dto.Mentoring;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ds on 2017-12-10.
 */
@Mapper
public interface MentoringMapper {
    Mentoring findByAid(int a_id);
    Mentoring showApply(int a_id);
    int showCount(int a_id);
    List<Mentee> checkMentee(@Param("a_id") int a_id, @Param("id") int id);
}
