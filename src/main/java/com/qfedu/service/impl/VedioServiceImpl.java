package com.qfedu.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VedioDao;
import com.qfedu.entity.Vedio;
import com.qfedu.service.VedioService;
import com.qfedu.vo.Vvedio;
import com.qfedu.vo.Vvedio2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VedioServiceImpl implements VedioService {

    @Autowired
    private VedioDao vedioDao;

    @Override
//    public Map<String, Object> findAllVedioManage(String speakerName, String courseTitle,Integer page, Integer limit) {
    public Map<String, Object> findAllVedioManage(String speakerName, String courseTitle,String title, Integer page, Integer limit) {

        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
//
        PageHelper.startPage(page ,limit);

//        List<Vvedio> list = vedioDao.findAll(speakerName, courseTitle);
        List<Vvedio> list = vedioDao.findAll(speakerName, courseTitle,title);

        long total = ((Page) list).getTotal();
//        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 结合layui的表格组件，0表示成功
        map.put("msg", "");
        map.put("count", total);// 表中总记录数
        map.put("data", list); // 获取到的分页数据

        return map;

    }

    @Override
    public void addvedio(Vedio vedio) {
        vedioDao.addvedio(vedio);
    }

    @Override
    public void deleteById(Integer id) {
        vedioDao.deleteById(id);
    }

    @Override
    public List<Vvedio2> findById(Integer id) {
        List<Vvedio2> list = vedioDao.findById(id);
        return list;
    }

    @Override
    public void updateVedio(Vedio vedio) {

        vedioDao.updateVedio(vedio);

    }


    @Override
    public Integer deleteManyVideo(int[] idArr) {

        return vedioDao.deleteManyVideo(idArr);
    }

}
