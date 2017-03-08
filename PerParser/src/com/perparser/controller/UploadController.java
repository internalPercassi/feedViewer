package com.perparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Stream;

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
