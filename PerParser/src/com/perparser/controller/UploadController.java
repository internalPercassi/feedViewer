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
    //@PostMapping("/upload") // //new annotation since 4.3
    public ModelAndView singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception {
    	
    	BufferedWriter bw = null;
    	FileWriter fw = null;
    	List<Object> data = new ArrayList<Object>();
    	try
    	{
    		
        	InputStream inputStream = file.getInputStream();
        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String fullPath = context.getRealPath("/WEB-INF/resources/aGL.csv");
            
            fw = new FileWriter(fullPath, false);
            bw = new BufferedWriter(fw);
            
        	String line = null;
        	
        	while ((line = bufferedReader.readLine()) != null)
        	{
        		List<String> rowValues = new ArrayList<>();
                switch (fileType)
                {
    			case "GL":
    				rowValues.add(line.substring(0, 2));
    				rowValues.add(line.substring(2, 5));
    				rowValues.add(line.substring(5, 15));
    				rowValues.add(line.substring(15, 18));
    				rowValues.add(line.substring(28, 64));
    				rowValues.add(line.substring(64, 67));
    				rowValues.add(line.substring(150, 163));
    				rowValues.add(line.substring(163, 176));
    				rowValues.add(line.substring(176, 191));
    				data.add(rowValues);
//            		bw.append(line,0,2);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,2,5);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,5,15);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,15,18);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,38,64);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,64,67);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,150,163);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,163,176);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,176,191);
//            		bw.append(NEW_LINE_SEPARATOR);
    				break;
    			case "OS":
//            		bw.append(line,0,26);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,26,46);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,5,15);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,15,18);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,38,64);
//            		bw.append(COMMA_DELIMITER);
//            		bw.append(line,64,67);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,150,163);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,163,176);
//              		bw.append(COMMA_DELIMITER);
//            		bw.append(line,176,191);
//            		bw.append(NEW_LINE_SEPARATOR);
    				
    				break;
    			case "OPE":
    				
    				break;
    			case "OBE":
    				
    				break;
    			default:
    				break;
    			}
        	}
    	} 
    	catch (IOException e)
    	{
    		e.printStackTrace();
		}
    	finally
    	{

			try
			{

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} 
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
    	
    	 redirectAttributes.addFlashAttribute("some", "thing");
    
    	
		ModelAndView model = new ModelAndView("redirect:" + context.getContextPath());
		model.addObject("data", data);

		return model;
    }

    @GetMapping("/uploadResult")
    public String uploadStatus()
    {
        return "uploadResult";
    }

	@Override
	public void setServletContext(ServletContext servletContext)
	{
		  this.context = servletContext;
		
	}

}
