import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDTFWithItext
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		try
		{
			OutputStream file = new FileOutputStream(new File ("example.pdf"));
			Document doc = new Document();
			PdfWriter.getInstance(doc, file);
			doc.open();
			doc.add(new Paragraph("Hello Pfun Class"));
			doc.add(new Paragraph("What fun is this?"));
			doc.add(new Paragraph(new Date().toString()));
			doc.close();
			file.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
