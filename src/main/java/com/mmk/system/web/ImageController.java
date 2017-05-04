package com.mmk.system.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mmk.common.tool.FileClient;
import com.mmk.common.util.VerifyCodeUtil;

@Controller
@RestController
public class ImageController {

	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "/image/upload")
	@ResponseBody
	public Map<String, Object> upload(MultipartFile file, String callback) {
		long start = System.currentTimeMillis();
		Map<String, Object> result = new HashMap<String, Object>();
		if (file.getSize() > 0) {
			try {
				String imageUrl = FileClient.getDefault().upload("tuan", file).getImageUrl();
				result.put("success", true);
				result.put("file", imageUrl);
				result.put("callback", callback);

			} catch (IOException e) {
				result.put("success", false);
				result.put("message", e.getMessage());
				e.printStackTrace();
			}
		}
		log.debug("文件上传用时：" + String.valueOf(System.currentTimeMillis() - start));
		return result;
	}

	/**
	 * 百度编辑器 专用 图片上传
	 * 
	 * @param dir
	 * @param pictitle
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/ueditor/add")
	@ResponseBody
	public Map addForUeditor(String dir, String pictitle, @RequestParam MultipartFile file,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "SUCCESS");
		if (file.isEmpty()) {
			map.put("state", "未包含上传的图片");
		}
		try {
			String url = FileClient.getDefault().upload("detailimage", file).getImageUrl();
			map.put("title", "image");
			map.put("original", file.getOriginalFilename());
			map.put("url", url);
		} catch (IOException e) {
			map.put("state", "文件上传失败");
			e.printStackTrace();
		}

		return map;
	}
	
	@RequestMapping("/verifycode")
	public void  verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
		 //生成随机字串 
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4); 
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //生成图片 
        int w = 100, h = 40; 
        VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode); 
	}
}
