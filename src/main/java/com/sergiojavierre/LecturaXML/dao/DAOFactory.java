package com.sergiojavierre.LecturaXML.dao;

import com.sergiojavierre.LecturaXML.dao.users.DAODiscos;
import com.sergiojavierre.LecturaXML.dao.users.DAODiscosXML;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAODiscos daoDiscos;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAODiscos getDaoDiscos() {
        if(daoDiscos == null){
            daoDiscos = new DAODiscosXML();
        }
        return daoDiscos;
    }
}
