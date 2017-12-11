package net.skhu.test.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ds on 2017-12-11.
 */
@Data
public class Mentoring implements Serializable {
    private static final long serialVersionUID = 1L;

    //멘토링 id
    private int m_id;
    //멘토 id
    private int ID;
    //멘토 신청서 id
    private int a_id;
    //멘토링 생성 날짜
    private Date m_date;
    //멘토 정보
    private int u_id; //학번
    private String u_name; //이름
    private String u_tel; //전화번호
    private int u_grade; //학년
    private String d_id1; // 소속학과
    private String u_email; // 이메일 주소
    //멘토 신청서 정보
    private String a_title;
    private String a_sub;
    private String a_name;
    private String a_aim;
    private String a_contents;
    private String a_method;
    private String a_hours;
    private String a_rank;
    private String a_fileUrl;
    private int a_num;
    private int a_type;
    private String a_photoUrl;
}
