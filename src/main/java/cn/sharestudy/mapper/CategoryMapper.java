package cn.sharestudy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sharestudy.mapper.po.Category;

@Repository
public interface CategoryMapper {

    public int insert(Category category);

    public int update(Category category);
    
    public Category selectById(int id) ;

    public List<Category> selectAll();
}
