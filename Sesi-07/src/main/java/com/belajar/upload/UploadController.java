package com.belajar.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController{

	private String saveDirectory = "../Sesi-07/src/main/images/";

@RequestMapping("/foto/hasilUpload")
    public ModelMap hasilUpload() throws Exception{
		File directory = new File(saveDirectory);
				File[] fList = directory.listFiles();
				for (File file : fList){
						System.out.println(file.getName());
				}
			ModelMap mm = new ModelMap();
			mm.addAttribute("hasilUpload", directory);
        return mm;
    }

@RequestMapping(value = "/foto/upload", method = RequestMethod.POST)
	public String uploadImage(@RequestParam("photofile") MultipartFile hasilUpload) throws IOException{		
			if (!hasilUpload.isEmpty()) {
			/* start transferTo directory /Sesi-07/ */
			  if (!hasilUpload.getOriginalFilename().equals("")) {
                   hasilUpload.transferTo(new File(saveDirectory + hasilUpload.getOriginalFilename()));
				   return "redirect:hasilUpload";
                } 
			/* end of transfer file*/			
				byte[] bytes = hasilUpload.getBytes();
				return "redirect:/aplikasi/foto/hasilUpload";
				} else {
					return "redirect:/aplikasi/foto/upload";
			}
	}

@RequestMapping(value = "/foto/upload", method = RequestMethod.GET)
    public void upload() {
    }
}