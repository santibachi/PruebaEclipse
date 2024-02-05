package com.pruebas.contro;




import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebas.model.PasInt;
import com.pruebas.model.PeliculaInt;
import com.pruebas.model.SalaInt;



@Controller
public class Control {
	
//Comentario
	 @Autowired
	 private PeliculaInt peliInt;

	 @Autowired
	 private PasInt pasInt;

	  @GetMapping("/index")
	    public String index(Model model) {
	        
	        return "listar";
	    }
	 
	    @GetMapping("/con1")
	    public String consulta1(Model model) {
	        model.addAttribute("lista1", peliInt.con1());
	        return "listar";
	    }
	    
	    @GetMapping("/con2")
	    public String consulta2(Model model) {
	      
	    	model.addAttribute("lista2", peliInt.con2());
	        return "listar";
	    }
	    
	    
	    //http://localhost:8081/con3?genero=COMEDIA
	    @GetMapping("/con3")
	    public String consulta3(@RequestParam(name="genero") String genero,Model model) {
	      
	    	model.addAttribute("lista3", pasInt.con3(genero));
	        return "listar";
	    }
	    
	    
	    @GetMapping("/con4")
	    public String consulta4(Model model) {
	      
	    	model.addAttribute("lista4", pasInt.con4());
	        return "listar";
	    }
	    
	    @GetMapping("/con5")
	    public String consulta5(Model model) {
	      
	    	model.addAttribute("lista5", peliInt.con5());
	        return "listar";
	    }
	    
	    @GetMapping("/con6")
	    public String consulta6(Model model) {
	      
	    	model.addAttribute("lista6", pasInt.con6());
	        return "listar";
	    }
	    
	    @GetMapping("/con7")
	    public String consulta7(Model model) {
	        Date startDate=new Date(2016-1-1);
	        Date endDate=new Date(2017-1-1);
	    	model.addAttribute("lista7", pasInt.con7(startDate,endDate));
	        return "listar";
	    }
	
	
}
