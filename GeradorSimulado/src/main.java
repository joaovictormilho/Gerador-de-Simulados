
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;


public class main {
    public static void main(String []argv){
        //Prova p=new Prova();
        ManipulaAssunto l=new ManipulaAssunto();//p.getAssuntos();
        l.addAssunto(new Assunto("dsfghjadsf",9));
        l.addAssunto(new Assunto("dsadsf",9));
        l.addAssunto(new Assunto("dsfhjadsf",9));
        l.addAssunto(new Assunto("dadsf",9));
        l.addAssunto(new Assunto("dsghjadsf",9));
        l.addAssunto(new Assunto("dsdsf",9));
        l.addAssunto(new Assunto("dsfhjadsf",9));
        l.addAssunto(new Assunto("dssf",9));
        l.addAssunto(new Assunto("dsfhjadsf",9));
        l.addAssunto(new Assunto("dssf",9));
        l.addAssunto(new Assunto("dsfgdsf",9));
        l.addAssunto(new Assunto("dsaf",9));
        l.addAssunto(new Assunto("dsfgadsf",9));
        l.addAssunto(new Assunto("dadsf",9));
        l.addAssunto(new Assunto("dsfgjadsf",9));
        l.addAssunto(new Assunto("dsadf",9));
        l.addAssunto(new Assunto("dsfhjhadsf",9));
        l.addAssunto(new Assunto("dssfdfjh",9));
        l.addAssunto(new Assunto("dsfhjadsgjf",9));
        l.addAssunto(new Assunto("dssfj",9));
        l.addAssunto(new Assunto("dsfgdçsf",9));
        l.addAssunto(new Assunto("dsaref",9));
        l.addAssunto(new Assunto("dsfgaiudsf",9));
        l.addAssunto(new Assunto("dadsqf",9));
        l.addAssunto(new Assunto("dsfgjweadsf",9));
        l.addAssunto(new Assunto("dsadfp",9));
        l.addAssunto(new Assunto("o",9));
        l.addAssunto(new Assunto("i",9));
        l.addAssunto(new Assunto("yu",9));
        l.addAssunto(new Assunto("ew",9));
        l.addAssunto(new Assunto("ty",9));
        l.addAssunto(new Assunto("w",9));
        l.addAssunto(new Assunto("wr",9));
        l.addAssunto(new Assunto("r",9));
        l.addAssunto(new Assunto("ghj",9));
        l.addAssunto(new Assunto("io",9));
        l.addAssunto(new Assunto("ioç",9));
        l.addAssunto(new Assunto("ol",9));
        l.addAssunto(new Assunto("wed",9));
        l.addAssunto(new Assunto("",9));
        l.addAssunto(new Assunto("ef",9));
        l.addAssunto(new Assunto("ewds",9));
        l.addAssunto(new Assunto("aews",9));
        l.addAssunto(new Assunto("",9));
        l.addAssunto(new Assunto("fe",9));
        l.addAssunto(new Assunto("rthgy",9));
        l.addAssunto(new Assunto("reg",9));
        l.addAssunto(new Assunto("hgj",9));
        l.addAssunto(new Assunto("rfsg",9));
        l.addAssunto(new Assunto("khl",9));
        l.addAssunto(new Assunto("dgh",9));
        l.addAssunto(new Assunto("hkl",9));
        l.addAssunto(new Assunto("lik",9));
        ListarAssuntoGUI o=new ListarAssuntoGUI(new JButton(),l);
        JFrame p=new JFrame("dslj");
        p.add(o);
        p.setVisible(true);
        p.pack();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		try {
//			p.geraCSV();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
    }
}
