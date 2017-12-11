package net.skhu.test.service;

import net.skhu.test.dto.Apply;
import net.skhu.test.dto.Mentoring;
import net.skhu.test.mapper.ApplyMapper;
import net.skhu.test.mapper.MenteeMapper;
import net.skhu.test.mapper.MentoringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ds on 2017-12-10.
 */
@Service
public class ApplyService {

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    MentoringMapper mentoringMapper;

    @Autowired
    MenteeMapper menteeMapper;

    //멘토방 목록
    public List<Apply> mentoringList() {
        return applyMapper.findAll();
    }

    //멘토인지 멘티인지 멘토링을 신청하는 사람인지 판단
    public int checkMento(int id, int a_id) {
        //멘토인지 판단
        if(applyMapper.findByIdAndAid(id, a_id) > 0) {
            return 1;
        }else {
            //멘티인지 판단
            Mentoring mentoring = mentoringMapper.findByAid(a_id);
            if(menteeMapper.findByIdAndMid(id, mentoring.getM_id()) > 0) {
                return 2;
            }else {
                return 0;
            }
        }
    }

    //신청서 작성
    public int insert(Apply apply) {
        applyMapper.insert(apply);
        mentoringMapper.insert(apply.getA_id(), apply.getID());
        return apply.getA_id();
    }

    public Apply findOne(int a_id) {
        return applyMapper.findByAid(a_id);
    }

    public void editOrDelete(String button, Apply apply) {
        if(button.equals("edit")) {
            applyMapper.updateContents(apply);
        }else {
            //applyMapper.delete(apply.getA_id());
        }
    }
}
