/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.pdfdoc.provider;

import java.io.FileOutputStream;
import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.pdfdoc.PDFDocManager;
import com.sciits.blockbuster.pdfdoc.model.TransformationMemorandam;

public class TransformationMemorandamPDFDocProvider {
	private static TransformationMemorandamPDFDocProvider instance = null;

	Logger log = Logger.getLogger(TransformationMemorandamPDFDocProvider.class);

	// ========================================================================

	private TransformationMemorandamPDFDocProvider() {
	}

	// ========================================================================

	public static synchronized TransformationMemorandamPDFDocProvider getInstance() {
		if (instance == null) {
			instance = new TransformationMemorandamPDFDocProvider();
		}
		return instance;
	}

	// =========================================================================

	// Setting Header To PDF pages
	public class HeaderTable extends PdfPageEventHelper {
		protected PdfPTable header;

		public HeaderTable(PdfPTable header) {
			this.header = header;
		}

		public void onStartPage(PdfWriter writer, Document document) {
			// (xxxx, xxxx, ->, ^)
			header.writeSelectedRows(0, -1, 450, 825, writer.getDirectContent());
		}
	}

	// =========================================================================

	// Setting Footer To PDF pages
	public class FooterTable extends PdfPageEventHelper {
		protected PdfPTable footer;

		public FooterTable(PdfPTable footer) {
			this.footer = footer;
		}

		public void onEndPage(PdfWriter writer, Document document) {
			footer.writeSelectedRows(0, -1, 36, 64, writer.getDirectContent());
		}
	}

	// =============================================================================

	// Setting PageNo's To PDF pages
	public class PageNumbers extends PdfPageEventHelper {

		protected Phrase pageNo;

		public void setPageNumber(Phrase pageNo) {
			this.pageNo = pageNo;
		}

		@Override
		public void onEndPage(PdfWriter writer, Document document) {
			PdfContentByte canvas = writer.getDirectContentUnder();
			ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, pageNo, 559, 10, 0);
		}
	}

	// =========================================================================================

	public String getTransformationMemorandam(TransformationMemorandam transformationMemorandam, long userId)
			throws BlockbusterException {
		String pdfDocPath = null;
		String logTag = "getTransformationMemorandam()";
		
		try {
			Document document = new Document(PageSize.A4, 36, 36, 50, 36);
			pdfDocPath = Constants.DOCUMENTS_FOLDER +"/"+ userId +"/"+ transformationMemorandam.getHeader() + "_"
					+ System.currentTimeMillis() + ".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDocPath));

			Image image;
			image = Image.getInstance(transformationMemorandam.getImageName());
			PdfPTable imageHeader = new PdfPTable(1);
			PdfPCell cell = new PdfPCell();
			imageHeader.setTotalWidth(80);
			cell = new PdfPCell(image, true);
			cell.setBorder(Rectangle.NO_BORDER);
			imageHeader.addCell(cell);
			// image.scaleAbsolute(30f, 30f);
			HeaderTable eventHeader = new HeaderTable(imageHeader);
			writer.setPageEvent(eventHeader);

			String footer = transformationMemorandam.getFooterLeft() + "                                 "
					+ transformationMemorandam.getFooterRight();
			Font font = new Font(FontFactory.getFont(FontFactory.COURIER, 8));
			PdfPTable table = new PdfPTable(1);
			table.setTotalWidth(523);

			PdfPCell footerCell = new PdfPCell(new Phrase(footer, font));
			footerCell.setBackgroundColor(new BaseColor(205, 205, 205));
			footerCell.setBorderColorTop(BaseColor.BLACK);
			footerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(footerCell);
			FooterTable event = new FooterTable(table);

			writer.setPageEvent(event);
			PageNumbers eventPage = new PageNumbers();
			writer.setPageEvent(eventPage);

			// document open
			document.open();
			Rectangle rect= new Rectangle(6,6,587,835);
	         /* rect.enableBorderSide(1);
	          rect.enableBorderSide(2);
	          rect.enableBorderSide(4);
	          rect.enableBorderSide(8);*/
	          rect.setBorderWidth(2);
	          rect.setBorder(Rectangle.BOX);
	          rect.setBorderColor(BaseColor.BLACK);
	          document.add(rect);

			headerName(document, transformationMemorandam.getHeader());
			transformationMemorandamFeilds(transformationMemorandam, document);

			// document close
			document.close();
		} catch (Exception e) {
			String errorMsg = logTag + "Should handle the Document Exception";
			log.error(errorMsg);
			throw new BlockbusterException(errorMsg, e);
		}
		return pdfDocPath;
	}

	// ========================================================================================

	// Setting Header Name  to pdf

	public void headerName(Document document, String header) throws BlockbusterException {
		String logTag = "headerName()";
		try {
			Paragraph paragraph2 = new Paragraph();
			paragraph2.setFont(FontFactory.getFont(FontFactory.COURIER_BOLD, 30));
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			paragraph2.add(Chunk.NEWLINE);
			paragraph2.add(Chunk.NEWLINE);
			paragraph2.add(Chunk.NEWLINE);
			paragraph2.add(header);

			document.add(paragraph2);
		} catch (DocumentException e) {
			String errorMsg = logTag + "Should handle the Document Exception";
			log.error(errorMsg);
			throw new BlockbusterException(errorMsg, e);
		}
	}

	// ========================================================================================

	// List of transformation Memorandum Fields
	public void transformationMemorandamFeilds(TransformationMemorandam transformationMemorandam, Document document)
			throws BlockbusterException {
		String logTag = "chaterFeilds()";

		try {
			Paragraph chaterParagraph = new Paragraph();
			chaterParagraph.setFont(FontFactory.getFont(FontFactory.HELVETICA, 12));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(new Phrase("MBC Name Limited By Shares :  " + transformationMemorandam.getMbcName()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(
					new Phrase("Registered Name Of Agent   :  " + transformationMemorandam.getRegisteredAgentName()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(new Phrase(
					"Registered Office Address  :  " + transformationMemorandam.getRegisteredOfficeAddress()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(new Phrase("Country                     :  " + transformationMemorandam.getCountry()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(new Phrase("Location                    :  " + transformationMemorandam.getLocation()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph
					.add(new Phrase("Business Purpose            :  " + transformationMemorandam.getBusinessPurpose()));
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.add(Chunk.NEWLINE);
			chaterParagraph.setAlignment(Element.ALIGN_LEFT);
			chaterParagraph.add(Chunk.NEWLINE);

			document.add(chaterParagraph);
		} catch (Exception e) {
			String errorMsg = logTag + "Should handle the Document Exception";
			log.error(errorMsg);
			throw new BlockbusterException(errorMsg, e);
		}

	}

	// ==================================================================================================

}
