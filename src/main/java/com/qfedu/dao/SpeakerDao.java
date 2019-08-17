package com.qfedu.dao;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerDao {

    public List<Speaker> findAll();


    public List<Speaker> findAll2();


    public void addSpeaker(Speaker speaker);


    public void deleteSpeaker(Integer id);

    public Speaker findById(Integer id);

    public void updateSpeaker(Speaker speaker);

}
