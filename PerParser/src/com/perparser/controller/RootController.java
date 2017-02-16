package com.perparser.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class RootController implements ServletContextAware{
	
	private ServletContext context;
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	
    @RequestMapping(value = "/PerParser", method = RequestMethod.GET)
    public String root() {
    	System.out.print("asdasdasdas");
        return "index";
    }
    
    
    
    @RequestMapping(value = "takis", method = RequestMethod.POST)
    //@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception {
    	
    	BufferedWriter bw = null;
    	FileWriter fw = null;
    	List<Object> data = new ArrayList<Object>();
    	List<String> rowValues = null;
    	try
    	{
    		
        	InputStream inputStream = file.getInputStream();
        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

             String fullPath = context.getRealPath("/WEB-INF/resources/aGL.csv");
            
            fw = new FileWriter(fullPath, false);
            bw = new BufferedWriter(fw);
            
        	String line = null;
        	
//            switch (fileType)
//            {
//			case "GL":
//				bw.append("GL,INS,PERTINENCY,UNIQUE PRODUCT CODE, DEPOSITOR,STOCKED QTY,BOOKED QTY,ACCOUNTING STATE");
//				bw.append(NEW_LINE_SEPARATOR);
//				break;
//			case "OS":
//				break;
//			case "OPE":	
//				break;
//			case "OBE":
//				break;
//			default:
//				break;
//			}
//        	
        	while ((line = bufferedReader.readLine()) != null)
        	{
        		rowValues = new ArrayList<>();
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
    	

		
    	redirectAttributes.addFlashAttribute("data", data);
    	
//		ModelAndView model = new ModelAndView();
//		model.addObject("message", "skata");
//		model.setViewName("uploadResult.jsp");
    	return "redirect:uploadResult";

    	
    }
    
	public void setServletContext(ServletContext servletContext)
	{
		  this.context = servletContext;
		
	}
}
