package net.skhu.test.mapper;

import net.skhu.test.dto.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 2017-12-10.
 */
@Mapper
public interface ApplyMapper {
    List<Apply> findAll();
    Apply findByAid(int a_id);
    int findByIdAndAid(@Param("id") int id, @Param("a_id") int a_id);
    ArrayList<Apply> findById(int id);
    void insert(Apply apply);
    void updateContents(Apply apply);
}
