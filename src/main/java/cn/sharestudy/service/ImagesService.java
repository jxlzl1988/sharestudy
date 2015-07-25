package cn.sharestudy.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sharestudy.common.Constants;
import cn.sharestudy.mapper.ImagesMapper;
import cn.sharestudy.mapper.po.Images;
import cn.sharestudy.service.vo.ImageVo;

/**
 * 图片service
 * @author sten
 *
 */
@Service
public class ImagesService extends BaseService {

	@Resource
	private ImagesMapper imagesMapper ;
	@Resource
	private PropertiesService propertiesService ;
	
	public void add(long id, int type, int targetid, String url) {
		
		Images image = new Images() ;
		image.setId(id);
		image.setCtype(type);
		image.setTargetid(targetid);
		image.setUrl(url);
		image.setEstate(Constants.estate_y);
		imagesMapper.insert(image) ;
	}
	
	public void update(Images images) {
		imagesMapper.update(images) ;
	}
	
	public List<ImageVo> selectImages(int targetId) {
		
		String wwwUrl = propertiesService.getValue(Constants.www_url_key) ;
		List<Images> images = imagesMapper.selectByTargetId(targetId) ;
		List<ImageVo> iVos = new ArrayList<ImageVo>() ;
		for(Images i : images) {
			iVos.add(new ImageVo(i, wwwUrl)) ;
		}
		
		return iVos ;
	}
	
}
