package com.sergiojavierre.LecturaXML.dao.users;

import com.sergiojavierre.LecturaXML.entities.Disco;

import java.util.Date;
import java.util.List;

public interface DAODiscos {
    public List<Disco> getAll();
    public Disco search(Integer id);
    public void add(Disco disco);
    public void borrar(Integer id);

}
