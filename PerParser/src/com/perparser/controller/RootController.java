package com.perparser.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    
    
    
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    //@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception {
    		
    	JSONObject obj = new JSONObject();
    	JSONArray tmplist = null;
    	JSONArray list = new JSONArray();
    	List<String> rowValues = null;
    		
    	InputStream inputStream = file.getInputStream();
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String fullPath = context.getRealPath("/WEB-INF/resources/aGL.csv");

    	String line = null;
    	while ((line = bufferedReader.readLine()) != null)
    	{
    		tmplist =  new JSONArray();
            switch (fileType)
            {
			case "GL":
				tmplist.add(line.substring(0, 2));
				tmplist.add(line.substring(2, 5));
				tmplist.add(line.substring(5, 15));
				tmplist.add(line.substring(15, 18));
				tmplist.add(line.substring(28, 64));
				tmplist.add(line.substring(64, 67));
				tmplist.add(line.substring(150, 160).replaceFirst("^0+(?!$)", ""));
				tmplist.add(line.substring(163, 173).replaceFirst("^0+(?!$)", ""));
				tmplist.add(line.substring(176, 191));
				
				list.add(tmplist);
				
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

    	
    	obj.put("data", list);
		
    	redirectAttributes.addFlashAttribute("data", obj);
    	
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
