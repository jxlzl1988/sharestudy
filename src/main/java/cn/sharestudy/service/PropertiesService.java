package cn.sharestudy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sharestudy.mapper.PropertiesMapper;
import cn.sharestudy.mapper.po.Properties;

@Service
public class PropertiesService {

	@Resource
	private PropertiesMapper propertiesMapper ;
	
	private Map<String, String> valuesMap = new HashMap<String, String>() ;
	
	@PostConstruct
	public void init() {
		List<Properties> prop = propertiesMapper.selectAll() ;
		for(Properties p : prop) {
			valuesMap.put(p.getCkey(), p.getCvalue()) ;
		}
	}
	
	public String getValue(String key) {
		return valuesMap.get(key) ;
	}
}
