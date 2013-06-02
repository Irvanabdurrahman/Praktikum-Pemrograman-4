package com.belajar.jasperReport;

import com.belajar.jasperReport.Produk;
import com.belajar.jasperReport.ProdukDao;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping("/jasperReport/")
public class ReportController {
    @Autowired private ProdukDao produkDao;
    
	 @RequestMapping(method= RequestMethod.GET,value="html")
    public ModelAndView tampilHtml(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("htmlReport", parameterMap);
        return mav;
    }
	
    @RequestMapping(method= RequestMethod.GET,value="pdf")
    public ModelAndView tampilPdf(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("pdfReport", parameterMap);
        return mav;
    }
    
    
    @RequestMapping(method= RequestMethod.GET,value="csv")
    public ModelAndView tampilCsv(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("csvReport", parameterMap);
        return mav;
    }

    @RequestMapping(method= RequestMethod.GET,value="xls")
    public ModelAndView tampilXls(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("xlsReport", parameterMap);
        return mav;
    }
	
    private Map<String, Object> listToMap() {
        List<Produk> tampil = new ArrayList<Produk>();
        try {
            tampil= produkDao.cariSemuaProduk();
        } catch (Exception ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRDataSource JRDataSource = new JRBeanCollectionDataSource(tampil);
        Map<String,Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("datasource", JRDataSource);
        return parameterMap;
    }
}
