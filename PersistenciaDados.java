
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;


//Sujeito a altera��es
class Temp{
    ArrayList<Questao>questoes;
    ArrayList<Assunto>assuntos;
    Temp(ArrayList<Questao>questoes,ArrayList<Assunto>assuntos){
        this.questoes=questoes;
        this.assuntos=assuntos;
    }
}
public class PersistenciaDados {
      final static String h="perguntas.xml";
    final static String l="assuntos.xml";
    static void pegaDados(ArrayList<Questao>questoes,ArrayList<Assunto>assuntos) {
    	XStream xstream = new XStream();
        Temp o;
    	xstream.alias("list", ArrayList.class);
    	try {
            BufferedReader input = new BufferedReader(new FileReader(h));
            o=(Temp)xstream.fromXML(input);
            questoes.addAll(o.questoes);
            assuntos.addAll(o.assuntos);
	}catch (FileNotFoundException e) {
	}
    }
    static void guardaDados(ArrayList<Questao>questoes,ArrayList<Assunto>assuntos) {
        XStream xstream = new XStream();
        PrintWriter out;
        Temp temp=new Temp(questoes,assuntos);
		try {
		out = new PrintWriter(h);
	        out.println(xstream.toXML(temp));
	        out.close();
                questoes.removeAll(questoes);
                assuntos.removeAll(assuntos);
		} catch (FileNotFoundException e) {
		}
                
    }  

}
