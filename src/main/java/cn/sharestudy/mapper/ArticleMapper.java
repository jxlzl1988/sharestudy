package cn.sharestudy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sharestudy.mapper.po.Article;

@Repository
public interface ArticleMapper {

    public int insert(Article article);

    public int update(Article article);

    public Article selectById(Integer id);

    public List<Article> selectByCategoryId(int categoryId);

}
