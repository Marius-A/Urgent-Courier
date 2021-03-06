package com.mariusiliescu.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.model.entities.Factura;
import com.mariusiliescu.model.entities.Pachet;

public class PDFBuilder {
	public static void creareFactura(Factura f) throws IOException, DocumentException{
		Document document=new Document(PageSize.A4);
		PdfWriter writer =  PdfWriter.getInstance(document,new FileOutputStream("resources/factura.pdf"));
		document.open();
		

		Font headFont = new Font(FontFamily.TIMES_ROMAN, 20.0f, Font.BOLD, BaseColor.BLACK);
		Image logo = Image.getInstance("resources/logo.png");
		logo.scaleAbsolute(50f, 50f);
		Paragraph doctype = new Paragraph("FACTURA",headFont);
		doctype.setAlignment(Element.ALIGN_RIGHT);
		document.add(logo);
		document.add(doctype); 
		
		
		document.add(new Paragraph("SC.Urgent Curier")); 
		document.add(new Paragraph("______________________________________________________________________________"));
		document.add(new Paragraph(" ")); 
//
        StringBuilder sb1 = new StringBuilder();
        sb1.append("<p><font size=\"2\">");
        sb1.append("<b>Nr. reg. com :</b> J00/032/2016<br/>");
        sb1.append("<b>C.U.I :</b> 48565846516546846516<br/>");
        sb1.append("<b>Sediu :</b> Ro. Dj. Craiova  Str. Mihai Viteazu Bl. C23 , Ap. 3.<br/>");
        sb1.append("<b>Cont :</b> RO0732DCSDC767D6C656565787870000<br/>");
        sb1.append("<br/> <br/> <br/>");
        sb1.append("<b>Telefon :</b> 0271236521 / 075852321<br/>");
        sb1.append("<b>E-mail :</b> urgentcurier@ucservice.com<br/>");
        sb1.append("<b>Site :</b> www.urgentcurierex.com<br/>");
        sb1.append("</font></p>");
 //
        
        Comanda c = f.getComanda();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<p><font size=\"2\">");
        sb2.append("<b>Cod factura: </b>"+f.getCodFactura()+"<br/>");
        sb2.append("<b>Cod comanda :</b> "+c.getCodComanda()+"<br/>");
        sb2.append("<b>Expeditor : </b> "+c.getExpeditor().getNume()+"  <b>  CUI/CNP :</b> "+c.getExpeditor().getSSNCUI()+"<br/>");
        sb2.append("<b>Data preluare :</b> "+c.getDataPreluare()+"<br/>");
        sb2.append("</font></p>");
        
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell1 = new PdfPCell();
        ElementList list1 = XMLWorkerHelper.parseToElementList(sb1.toString(), null);
        for (Element element : list1) {
            cell1.addElement(element);
        }
        
        PdfPCell cell2 = new PdfPCell();
        ElementList list2 = XMLWorkerHelper.parseToElementList(sb2.toString(), null);
        for (Element element : list2) {
            cell2.addElement(element);
        }
        
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorder(PdfPCell.NO_BORDER);
        
        table.addCell(cell1);
        
        table.addCell(cell2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);


        
        table.setTotalWidth(PageSize.A4.getWidth());
        table.setLockedWidth(true);
        PdfContentByte canvas = writer.getDirectContent();
        PdfTemplate template = canvas.createTemplate(
            table.getTotalWidth(), table.getTotalHeight());
        table.writeSelectedRows(0, -1, 0, table.getTotalHeight(), template);
        Image img = Image.getInstance(template);
        img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
        document.add(img);
        
        
    	document.add(new Paragraph("______________________________________________________________________________"));
		document.add(new Paragraph(" ")); 
		
		Font font = new Font(FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
        document.add(new Paragraph("Intocmit de :"+ f.getIntemeietor().getNume() +" "+ f.getIntemeietor().getPrenume()+" CNP :"+f.getIntemeietor().getCnp()+" E-mail :"+f.getIntemeietor().geteMail(),font));
        
        
       
        //special font sizes
        Font bfBold11 = new Font(FontFamily.TIMES_ROMAN, 11, Font.BOLD, new BaseColor(0, 0, 0)); 
        Font bf10 = new Font(FontFamily.TIMES_ROMAN,10); 
        Font bf8 = new Font(FontFamily.TIMES_ROMAN,8); 
        
        Paragraph paragraph = new Paragraph(" ");
        
        float[] columnWidths = {2f, 1.5f, 2f, 2f,5f};
        //create PDF table with the given widths
        PdfPTable table3 = new PdfPTable(columnWidths);
        // set table width a percentage of the page width
        table3.setWidthPercentage(90f);

        //insert column headings
        insertCell(table3, "Cod Pachet", Element.ALIGN_CENTER, 1, bfBold11);
        insertCell(table3, "Greutate", Element.ALIGN_CENTER, 1, bfBold11);
        insertCell(table3, "Dimensiune", Element.ALIGN_CENTER, 1, bfBold11);
        insertCell(table3, "Conditii Speciale", Element.ALIGN_CENTER, 1, bfBold11);
        insertCell(table3, "Destinatar", Element.ALIGN_CENTER, 1, bfBold11);
        table3.setHeaderRows(1);
        
        
        for(Pachet p : c.getListaPachete()){
            insertCell(table3,(String) p.getCodPachet().toString(), Element.ALIGN_LEFT, 1, bf10);
            insertCell(table3, p.getGreutate().toString(),  Element.ALIGN_LEFT, 1, bf10);
            insertCell(table3, p.getDimensiune().toString(), Element.ALIGN_LEFT, 1, bf8);
            insertCell(table3, p.getConditiiSpeciale().name(),  Element.ALIGN_LEFT, 1, bf10);
            insertCell(table3, p.getDestinatar().toString(),  Element.ALIGN_LEFT, 1, bf8);
        }

      
      
        
        
        //add the PDF table to the paragraph 
        paragraph.add(table3);
        // add the paragraph to the document
        document.add(paragraph);

        
        
        
		document.close(); 
		open(new File("resources/factura.pdf"));	
	}
	
	
	
	public static void open(File document) throws IOException {
	    Desktop dt = Desktop.getDesktop();
	    dt.open(document);
	}
	
	
	
	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		  
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		  
		 }
}
