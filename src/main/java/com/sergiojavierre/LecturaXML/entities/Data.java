package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Data {

        @JacksonXmlElementWrapper(localName = "discos")
        @JacksonXmlProperty(localName = "disco")
        List<Disco> discos;

        public Data(){}

        public Data(List<Disco> discos) {
            if(discos != null) {
                this.discos = discos;
            }
            else this.discos = new ArrayList<>();
        }

        public List<Disco> getDiscos() {
            return discos;
        }

        public void setDiscos(List<Disco> discos) {
            this.discos = discos;
        }
    }


