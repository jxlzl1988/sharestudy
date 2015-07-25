package cn.sharestudy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sharestudy.mapper.po.Properties;

@Repository
public interface PropertiesMapper {

    public Integer insert(Properties properties);

    public Integer update(Properties properties);

    public List<Properties> selectAll();

}
