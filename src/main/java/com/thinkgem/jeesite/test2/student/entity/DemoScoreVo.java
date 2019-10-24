package com.thinkgem.jeesite.test2.student.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;


public class DemoScoreVo  extends DataEntity<DemoScore> {

    private static final long serialVersionUID = 1L;
    private DemoStudent demoStudent;		// 学生编号


    private DemoSubject demoSubject;		// 学生编号

    private String scoreStart;		// 分数

    private String scoreEnd;		// 分数

    public DemoScoreVo() {
        super();
    }

    public DemoScoreVo(String id){
        super(id);
    }


    public DemoStudent getDemoStudent() {
        return demoStudent;
    }

    public void setDemoStudent(DemoStudent demoStudent) {
        this.demoStudent = demoStudent;
    }

    public DemoSubject getDemoSubject() {
        return demoSubject;
    }

    public void setDemoSubject(DemoSubject demoSubject) {
        this.demoSubject = demoSubject;
    }

    public String getScoreStart() {
        return scoreStart;
    }

    public void setScoreStart(String scoreStart) {
        this.scoreStart = scoreStart;
    }

    public String getScoreEnd() {
        return scoreEnd;
    }

    public void setScoreEnd(String scoreEnd) {
        this.scoreEnd = scoreEnd;
    }
}