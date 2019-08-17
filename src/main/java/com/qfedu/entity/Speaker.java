package com.qfedu.entity;

public class Speaker {

    private Integer id;
    private String speakerName;
    private String speakerDesc1;
    private String speakerJob;
    private String headImgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerDesc1() {
        return speakerDesc1;
    }

    public void setSpeakerDesc1(String speakerDesc1) {
        this.speakerDesc1 = speakerDesc1;
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }


    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", speakerName='" + speakerName + '\'' +
                ", speakerDesc1='" + speakerDesc1 + '\'' +
                ", speakerJob='" + speakerJob + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                '}';
    }
}
