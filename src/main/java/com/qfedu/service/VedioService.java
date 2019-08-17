package com.qfedu.service;



import com.qfedu.entity.Vedio;
import com.qfedu.vo.Vvedio;
import com.qfedu.vo.Vvedio2;

import java.util.List;
import java.util.Map;

public interface VedioService {

//    public Map<String,Object> findAllVedioManage(String speakerName,String courseTitle,Integer page, Integer limit);
    public Map<String,Object> findAllVedioManage(String speakerName,String courseTitle,String title,Integer page, Integer limit);


    //public Vvedio findByName(String speaker_name);

    public void addvedio(Vedio vedio);

    public void deleteById(Integer id);

    public List<Vvedio2> findById(Integer id);

    public void updateVedio(Vedio vedio);

    public Integer deleteManyVideo(int[] idArr);


}
