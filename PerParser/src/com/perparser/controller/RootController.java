package com.perparser.controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@Controller
public class RootController implements ServletContextAware{
    
    private ServletContext context;
    
    @RequestMapping(value="/")
    public ModelAndView  root(HttpServletRequest request)
    {
    	 Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
    	 JSONObject data = null;
    	 
    	  if (inputFlashMap != null) 
    		  data = (JSONObject) inputFlashMap.get("data");
        
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("data", data);

    	return mv;
    }
    
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    //@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("upload") MultipartFile file, @RequestParam("fileType") String fileType, RedirectAttributes redirectAttributes) throws Exception
    {
            
        JSONObject obj = new JSONObject();
        JSONArray tmplist = null;
        JSONArray list = new JSONArray();
        JSONArray headersList = new JSONArray();
    
        InputStream inputStream = file.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        
        try
        {   
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
                    tmplist.add(line.substring(0, 26));
                    tmplist.add(line.substring(26,46));
                    tmplist.add(line.substring(46, 56));
                    tmplist.add(line.substring(56, 68));
                    tmplist.add(line.substring(68, 80));
                    tmplist.add(line.substring(86, 92));        
                    list.add(tmplist);                  
                    break;
                case "OPE":                   
                    break;
                case "OBE":                   
                    break;
                default:
                    break;
                }
            }
            
            List<String>  columnList = null;
            switch (fileType)
            {
                
                case "GL":
                    columnList = Arrays.asList("GL", "INS", "Pertinency site", "Pertinency site Desc", "Unique product code", "Depositor", "Stocked Qty", "Booked Qty", "Accounting State");
                    headersList = createHeaderList(columnList);
                    obj.put("title", "Stocks File View");
                    break;
                case "OS":
                    
                    columnList = Arrays.asList("Codice Articolo", "Codice Modello", "Magazzino", "Inventario fisico", "In ordinazione", "Soglia riassortimento");
                    headersList = createHeaderList(columnList);
                    obj.put("title", "Overselling File View");
                    break;
            }
            
            obj.put("data", list);
            obj.put("headers", headersList);
            
        
        }
        catch(Exception e)
        {
            obj.put("data", list);
            obj.put("title", "Invalid File");
        }
        
        redirectAttributes.addFlashAttribute("data", obj);
    	
        return "redirect:/";
    }
    
    private JSONArray createHeaderList(List<String> columnList)
    {
        JSONArray headersList = new JSONArray();
        
        for (String headerStr : columnList) {
            JSONObject headerObj = new JSONObject();
            headerObj.put("title", headerStr);
            headersList.add(headerObj);
        }
        return headersList;
    }
    
    public void setServletContext(ServletContext servletContext)
    {
          this.context = servletContext;
    }
}