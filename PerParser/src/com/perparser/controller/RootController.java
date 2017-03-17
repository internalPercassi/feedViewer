package com.perparser.controller;

import com.perparser.parsers.BaseParser;
import com.perparser.parsers.ParserProvider;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/")
public class RootController implements ServletContextAware {

	private ServletContext context;
	@Autowired
	private ParserProvider parserProvider;

	@RequestMapping(value = "/")
	public ModelAndView root(HttpServletRequest request) {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		JSONObject data = null;

		if (inputFlashMap != null) {
			data = (JSONObject) inputFlashMap.get("data");
		}

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("data", data);

		return mv;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	//@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception {
		try {
			JSONObject obj = new JSONObject();
			InputStream inputStream = file.getInputStream();
			BaseParser parser = parserProvider.getParser(fileType);
			obj = parser.parseToJson(inputStream,"IT");
			redirectAttributes.addFlashAttribute("data", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
}
