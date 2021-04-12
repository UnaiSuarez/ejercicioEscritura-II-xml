package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.dao.users.DAODiscos;
import com.sergiojavierre.LecturaXML.entities.Data;
import com.sergiojavierre.LecturaXML.entities.Disco;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DiscosRestController {

    @GetMapping("/discos")
    public ResponseEntity<List<Disco>> readDiscos(){
        List<Disco> discos = DAOFactory.getInstance().getDaoDiscos().getAll();
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/disco/{id}")
    public ResponseEntity<Disco> readDisco(@PathVariable long id){
        try {
            Disco disco = DAOFactory.getInstance().getDaoDiscos().search((int) id);
            return ResponseEntity.ok(disco);
        } catch (ConfigDataResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // return 404, with null body
     }
    }

    @PostMapping(path="/disco",consumes="application/json")
    public ResponseEntity<String>  addDisco( @RequestBody Disco disco) {
        DAOFactory.getInstance().getDaoDiscos().add(disco);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping(path="/disco/borrar/{id}")
    public ResponseEntity<Disco> deleteDisco(@PathVariable long id) {
        try {
            DAOFactory.getInstance().getDaoDiscos().borrar((int) id);
            return ResponseEntity.ok().build();
        } catch (ConfigDataResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @PostMapping("/disco")
    public void addDisco(@RequestBody Disco disco){
        DAOFactory.getInstance().getDaoDiscos().add(disco);
    }



    @PostMapping(path="/disco",
            params = {"codigo", "cantante", "titulo","fecha"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> processJsonPostBody(
            @RequestBody Map<String, String> body) {

        return new ResponseEntity<>("Body param map: " + body, HttpStatus.OK);
    }
    */
}
