package com.belajar.springmvc;

import com.belajar.springmvc.Produk;
import com.belajar.springmvc.ProdukDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProdukController {
    
    @Autowired private ProdukDao produkDao;    
    
    @RequestMapping("/produk/daftar-produk")
    public ModelMap daftarProduk() throws Exception {
        List<Produk> hasil = produkDao.cariSemuaProduk();
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarProduk", hasil);
        return mm;
    }
    
    @RequestMapping(value="/produk/input-produk", method = RequestMethod.GET)
    public void tampilkanFormProduk(){
        System.out.println("Form Produk");
    }
    
    @RequestMapping(value = "/produk/input-produk", method = RequestMethod.POST)
    public String prosesFormProduk(@ModelAttribute Produk p) throws Exception {
        
        p.setTerakhirUpdate(new Date());
        
        produkDao.simpan(p);
        
        return "redirect:daftar-produk";
    }
}
