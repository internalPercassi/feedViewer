package com.perparser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;



@Controller
public class UploadController implements ServletContextAware {

	private ServletContext context;
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

    @GetMapping("/upload")
    public String index() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception {

		return new ModelAndView();
    }

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
	}

}
