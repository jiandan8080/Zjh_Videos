package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public Map<String, Object> findAllSpeaker1(Integer page, Integer limit) {

        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<Speaker> list = speakerDao.findAll();

        long total = ((Page) list).getTotal();
        int pages = ((Page) list).getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 结合layui的表格组件，0表示成功
        map.put("msg", "");
        map.put("count", total);// 表中总记录数
        map.put("data", list); // 获取到的分页数据

        return map;
    }

    @Override
    public List<Speaker> findAllSpeaker() {
        List<Speaker> list = speakerDao.findAll();
        if (list == null) {
            throw new RuntimeException("讲师不存在");
        }
        return list;
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerDao.addSpeaker(speaker);
    }

    @Override
    public void deleteSpeaker(Integer id) {
        speakerDao.deleteSpeaker(id);
    }

    @Override
    public Speaker findById(Integer id) {
        Speaker speaker = speakerDao.findById(id);
        return speaker;
    }

    @Override
    public void updateSpeaker(Speaker speaker) {
        speakerDao.updateSpeaker(speaker);
    }


}

