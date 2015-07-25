package cn.sharestudy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sharestudy.mapper.po.Images;

@Repository
public interface ImagesMapper {

    public int insert(Images images);

    public int update(Images images);

    public Images selectById(long id);

    public List<Images> selectByTargetId(int targetId);
}
