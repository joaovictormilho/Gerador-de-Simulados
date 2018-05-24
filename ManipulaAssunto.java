
import java.util.ArrayList;

public class ManipulaAssunto {
    ArrayList<Assunto> assuntos=new ArrayList<>();
    public boolean addAssunto(Assunto assunto){
        if(!assuntos.contains(assunto)){
            assuntos.add(assunto);
            return true;
        }
        return false;
    }
    public void geraCVS(Assunto assunto){
        
    }
    public void editarAssunto(String assunto,String novo){
        try{
            int k;
            Assunto temp=assuntos.get(k=assuntos.indexOf(assunto));
            if(temp.getAtivo()){
                temp.setAssunto(novo);
                assuntos.add(k, temp);
            }
        }catch(IndexOutOfBoundsException e){}     
    }
    public void excluirAssunto(String assunto){
        try{
            int k;
            Assunto temp=assuntos.get(k=assuntos.indexOf(assunto));
            if(temp.getAtivo()){
                temp.setAtivo(false);
                assuntos.add(k, temp);
            }
        }catch(IndexOutOfBoundsException e){}
    }
    public ArrayList<Assunto> listaAssunto(){
        return assuntos;
    }
}
