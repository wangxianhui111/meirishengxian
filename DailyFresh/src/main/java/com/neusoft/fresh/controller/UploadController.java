package com.neusoft.fresh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.fresh.utils.FileUpload;

/**
 * 图片上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
	// 读取配置文件
	@Value("${uploadPath}")
	private String uploadPath;
	
	/**
	 * 上传单张图片
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/picture",method=RequestMethod.POST)
	public Map<String, Object> uploadPicture(@RequestParam("file") MultipartFile file) {
		Map<String, Object> map=new HashMap<>();
		String picUrl = FileUpload.uplaod(uploadPath, file);
		if(picUrl!=null){
			map.put("data", picUrl);
			map.put("code", 200);
		}
		return map;
	}
}
