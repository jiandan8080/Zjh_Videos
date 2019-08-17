package com.qfedu.dao;

import com.qfedu.entity.Vedio;
import com.qfedu.vo.Vvedio;
import com.qfedu.vo.Vvedio2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VedioDao {

//    public List<Vvedio> findAll(@Param("speakerName") String speakerName, @Param("courseTitle") String courseTitle);
    public List<Vvedio> findAll(@Param("speakerName") String speakerName, @Param("courseTitle") String courseTitle, @Param("title") String title);


//    public Vvedio findBySpeakerName(String speaker_name);


    public void addvedio(Vedio vedio);

    public int deleteById(Integer id);

    public List<Vvedio2> findById(Integer id);

    public void updateVedio(Vedio vedio);

    public Integer deleteManyVideo(int[] idArr);


}
