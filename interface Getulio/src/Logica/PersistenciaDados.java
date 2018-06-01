package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;

public class PersistenciaDados {
    static void pegaDados(Prova prova) {
        XStream xstream = new XStream();
        xstream.alias("list", ArrayList.class);
        try {
            BufferedReader input = new BufferedReader(new FileReader("prova.xml"));
            prova = (Prova) xstream.fromXML(input);
        } catch (FileNotFoundException e) {
        }
    }
    static void guardaDados(Prova prova) {
        XStream xstream = new XStream();
        PrintWriter out;
        try {
            out = new PrintWriter("prova.xml");
            out.println(xstream.toXML(prova));
            out.close();
        } catch (FileNotFoundException e) {
        }
    }
}
