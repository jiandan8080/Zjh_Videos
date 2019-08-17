package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;
import java.util.Map;

public interface SpeakerService {

//    public List<Speaker> findAllSpeaker(Integer page, Integer limit);

    public Map<String,Object> findAllSpeaker1(Integer page, Integer limit);

    public List<Speaker> findAllSpeaker();

    public void addSpeaker(Speaker speaker);

    public void deleteSpeaker(Integer id);

    public Speaker findById(Integer id);

    public void updateSpeaker(Speaker speaker);

}
