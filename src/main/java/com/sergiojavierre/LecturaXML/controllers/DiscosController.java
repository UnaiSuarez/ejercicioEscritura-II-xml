package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Disco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiscosController {
    @GetMapping("/discosHTML")
    public String readDiscosHTML(Model model){
        List<Disco> discos = DAOFactory.getInstance().getDaoDiscos().getAll();
        model.addAttribute("discos",discos);
        return "discos";
    }
}
