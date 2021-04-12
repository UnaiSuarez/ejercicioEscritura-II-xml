package com.sergiojavierre.LecturaXML.dao.users;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sergiojavierre.LecturaXML.entities.Data;
import com.sergiojavierre.LecturaXML.entities.Disco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DAODiscosXML implements DAODiscos {

    private final String file = "discos.xml";


    @Override
    public List<Disco> getAll() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getDiscos();
    }

    @Override
    public Disco search(Integer id) {
        List<Disco> discos = getAll();
        Optional<Disco> posibleDisco = discos.stream().filter(disco->{
            return disco.getCodigo() == id;
        }).findFirst();
        return posibleDisco.orElse(null);
    }

    @Override
    public void add(Disco disco) {
        List<Disco> discos = getAll();
        discos.add(disco);
        save(discos);
    }

    @Override
    public void borrar(Integer id) {
        List<Disco> discos = getAll();
        for (int i = 0; i < discos.size(); i++) {
            if (discos.get(i).getCodigo() == id){
                discos.remove(i);
            }
        }
        save(discos);
    }

    private void save(List<Disco> discos){
        Data dataContainer = new Data(discos);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
