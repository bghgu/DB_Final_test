package net.skhu.test.service;

import net.skhu.test.dto.Mentoring;
import net.skhu.test.mapper.ApplyMapper;
import net.skhu.test.mapper.MentoringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ds on 2017-12-11.
 */
@Service
public class MentoringService {

    @Autowired
    MentoringMapper mentoringMapper;

    @Autowired
    ApplyMapper applyMapper;

    public Mentoring showMentoringInfo(int a_id) {
        return mentoringMapper.showApply(a_id);
    }

    public int showCount(int a_id, int num) {
        int count = mentoringMapper.showCount(a_id);
        int percent = (int)((double)count / (double)num * 100.0);
        return percent;
    }

    //멘토링 신청했는지 확인
    public boolean check(int a_id, int id, int percent) {
        boolean result = true;

        //그 방의 주인이면 false
        if(applyMapper.findById(id).size() == 1) {
            result = false;
        }
        //그방을 이미 신청했으면 false
        if(mentoringMapper.checkMentee(a_id, id).size() == 1 ) {
            result = false;
        }
        if(percent == 100) {
            result = false;
        }
        return result;
    }

    //멘토링 신청
    public int register(int a_id, int id) {
        int m_id = mentoringMapper.checkM_id(a_id);
        mentoringMapper.mentee(m_id, id);
        return m_id;
    }
}
