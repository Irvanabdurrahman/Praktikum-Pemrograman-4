package com.belajar.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController{
	
	/* Directory file */
	private String saveDirectory = "src/main/webapp/images/";

	/* Start of Post hasilUpload to directory with image file*/
	@RequestMapping("foto/hasilUpload")
    public ModelMap hasilUpload(){
	List<FileUpload> foto = new ArrayList<FileUpload>();
		File directory = new File(saveDirectory);
		File[] fList = directory.listFiles();
				for (File file : fList){
						 if(file.isFile()){
							FileUpload f = new FileUpload();
							f.setNama(file.getName());
							f.setUkuran(file.length()/1024);
							foto.add(f);
						}
				}
			ModelMap hasil = new ModelMap();
			hasil.addAttribute("hasilUpload", foto);
        return hasil;
    }
	/* End of Post hasilUpload to directory with image file*/

	/* Start of Post file upload to directory */
	@RequestMapping(value = "foto/upload", method = RequestMethod.POST)
		public String uploadImage(@RequestParam("photofile") MultipartFile hasilUpload) throws Exception{		
			if (!hasilUpload.isEmpty()) {
					/* start transferTo directory /Sesi-07/ */
					if (!hasilUpload.getOriginalFilename().equals("")) {
						hasilUpload.transferTo(new File(saveDirectory + hasilUpload.getOriginalFilename()));
					} 
					/* end of transfer file*/			
					return "redirect:/aplikasi/foto/hasilUpload";
				}else{
					return "redirect:/aplikasi/foto/upload";
			}
	}
	/* End of Post file upload to directory */
	
	/* Start of GET file upload  */
	@RequestMapping(value = "foto/upload", method = RequestMethod.GET)
    public void upload() {
    }
	/* End of GET file upload  */
	
	/* Start of action delete file one by one in table hasilUpload.jsp */
	 @RequestMapping("foto/hapus")
		public String hapusFile(@RequestParam("nama") String nama){
		File file = new File(saveDirectory +nama);
        boolean hapus = file.delete();        
        return "redirect:hasilUpload";
    }
	/* End of action delete file one by one in table hasilUpload.jsp */
	
	/* Start of action delete all file in table hasilUpload.jsp */
	@RequestMapping("foto/hapus-semua")
    public String hapusSemua(){
        File folder=new File(saveDirectory);
        File[] fList = folder.listFiles();
        for (File file : fList){
            if(file.isFile()){                
                File nama = new File(file.getName());
                boolean hapus = file.delete();
            }
        }    
        return "redirect:hasilUpload";
    }
	/* End of action delete all file in table hasilUpload.jsp */
    
	/* Start of action delete by Pilihan in table hasilUpload.jsp */
    @RequestMapping(value="foto/hapus-semua",method= RequestMethod.POST)
    public String hapusPilihan(@RequestParam("Pilihan") String[] Pilihan){
        if(Pilihan==null){
            return "redirect:hasilUpload";
        }
        for (String nama :Pilihan) {
          File nameFile  = new File(saveDirectory+nama);
          Boolean hapus = nameFile.delete();
        }
        return "redirect:hasilUpload";
    } 
	/* End of action delete by Pilihan in table hasilUpload.jsp */
}