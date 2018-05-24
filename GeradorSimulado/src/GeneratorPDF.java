import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratorPDF {

    public static void main(String[] args) {
           // criação do documento
          Document document = new Document();
          try {
            // PdfWriter writer = new PdfWriter("C:\\Users\\raykson santos\\Desktop\\PDF_DevMedia.pdf"); 
              PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\raykson santos\\Desktop\\PDF_DevMedia.pdf"));
              document.open();
              Image figura = Image.getInstance("C:\\Users\\raykson santos\\Desktop\\UFT.png");
              figura.setAbsolutePosition(0, 0);
              // adicionando um parágrafo no documento
              document.add(figura);
              document.add(new Paragraph("Gerando PDF \n-\n Java"));
}
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          document.close();
      }   
    }
