package cn.sharestudy.action.mis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.sharestudy.common.Constants;
import cn.sharestudy.common.ImageUrlUtil;
import cn.sharestudy.service.ImagesService;
import cn.sharestudy.service.PropertiesService;

/**
 * 上传图片服务 action
 *
 */
@Controller
@RequestMapping(value="/mis/image")
public class ImageAction {
	
	@Resource
	private ImagesService imagesService ;
	@Resource
	private PropertiesService propertiesService ;

   	/**
	 * 上传图片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String upload(HttpServletRequest request) {
		
		
        String rt = "";
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;     
            String wwwUrl = propertiesService.getValue(Constants.www_url_key) ;
            String localUrl = propertiesService.getValue(Constants.local_url_key) ;
            /**
             * type 1 article
             */
            int type = ServletRequestUtils.getIntParameter(multipartRequest, "type", 1) ;
            int targetid = ServletRequestUtils.getIntParameter(multipartRequest, "targetid", 0) ;
            CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
            String realfileName = file.getOriginalFilename();
            String filePath = "" ;
            if(type == 1) {
            	filePath = ImageUrlUtil.getArticleImageDir() ;
            }  else {
            	throw new Exception("type paramter wrong.type:" + type) ;
            }
            // 创建本地图片存储路径
            creatDir(localUrl + filePath);
            
            long id = ImageUrlUtil.getImageid() ;
            String fileName = id + realfileName.substring(realfileName.lastIndexOf("."));
            
            // 插入库
            imagesService.add(id, type, targetid, filePath + fileName); ;

            InputStream stream = file.getInputStream();
            String fileNameFull = localUrl +  filePath + fileName;
            OutputStream bos = new FileOutputStream(fileNameFull);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            stream.close();
            
            String tag = ImageUrlUtil.getImageTag(filePath + fileName) ;
            JSONObject object = new JSONObject() ;
            object.put("imageurl", wwwUrl + filePath + fileName) ;
            object.put("tag", tag) ;
            
            rt = object.toString() ;
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
        return rt;
	}
	
	/**
     * 创建文件目录
     * 
     */
    public static boolean creatDir(String aDir)
    {
        File aFile = new File(aDir);
        if(!aFile.exists())
        {
            return aFile.mkdirs();
        }
        return true;
    }
    
    /**
	 * 删除图片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/del",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		
		
        String rt = "";
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;     
            String wwwUrl = propertiesService.getValue(Constants.www_url_key) ;
            String localUrl = propertiesService.getValue(Constants.local_url_key) ;
            /**
             * type 1 books 2 chapter 3 blog
             */
            int type = ServletRequestUtils.getIntParameter(multipartRequest, "type", 1) ;
            int booksId = ServletRequestUtils.getIntParameter(multipartRequest, "booksId", 0) ;
            int chapterId = ServletRequestUtils.getIntParameter(multipartRequest, "chapterId", 0) ;
            int blogId = ServletRequestUtils.getIntParameter(multipartRequest, "blogId", 0) ;
            CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
            String realfileName = file.getOriginalFilename();
            String filePath = "" ;
            int targetid = 0 ;
            if(type == 1) {
            	filePath = ImageUrlUtil.getBooksImageDir(booksId+"") ;
            	targetid = booksId ;
            } else if(type == 2) {
            	filePath = ImageUrlUtil.getChapterImageDir(booksId+"", chapterId+"") ;
            	targetid = chapterId ;
            } else if(type == 3) {
            	filePath = ImageUrlUtil.getBlogImageDir(blogId+"") ;
            	targetid = blogId ;
            } else {
            	throw new Exception("type paramter wrong.type:" + type) ;
            }
            // 创建本地图片存储路径
            creatDir(localUrl + filePath);
            
            long id = ImageUrlUtil.getImageid() ;
            String fileName = id + realfileName.substring(realfileName.lastIndexOf("."));
            
            // 插入库
//            imageService.add(id, type, targetid, filePath + fileName);

            InputStream stream = file.getInputStream();
            String fileNameFull = localUrl +  filePath + fileName;
            OutputStream bos = new FileOutputStream(fileNameFull);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            stream.close();
            
            String tag = ImageUrlUtil.getImageTag(filePath + fileName) ;
            JSONObject object = new JSONObject() ;
            object.put("imageurl", wwwUrl + filePath + fileName) ;
            object.put("tag", tag) ;
            
            rt = object.toString() ;
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
        return rt;
	}
}
