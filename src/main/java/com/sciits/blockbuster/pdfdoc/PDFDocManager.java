/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.pdfdoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.pdfdoc.model.TransformationMemorandam;
import com.sciits.blockbuster.pdfdoc.provider.TransformationMemorandamPDFDocProvider;


public class PDFDocManager {

	Logger log = Logger.getLogger(PDFDocManager.class);
	
	private static PDFDocManager instance = null;

  // ========================================================================

  private PDFDocManager() { }

  // ========================================================================

  public static synchronized PDFDocManager getInstance() {

    if (instance == null) {
    	
    	instance = new PDFDocManager();
    	
    	try {
    		instance.init();
		} catch (Exception e) {
			
		}
    }
    return instance;
  }

  // ========================================================================

  private void init() throws IOException {
	  Properties prop = new Properties();
		String propFileName = "ApplicationResources.properties";
		InputStream inputStream;

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		// get the property value and print it out
		String pdfDocTemplates = prop.getProperty("bb.pdfdoc.templates");
		Constants.PDFDocument.PDF_DOC_TEMPLATES = pdfDocTemplates.split(",");
  }
  
  // ========================================================================
  
  public String populatePDF(String pdfType, Object dataObject, long userId) throws BlockbusterException {
	  String pdfDocPath = null;
	  String logTag = "populatePDF()";
	  
	  try {
		  if(Constants.PDFDocument.TRANSFORMATION_MEMORANDAM.equalsIgnoreCase(pdfType)) {
			  // Need to add implementation for Transformation Memorandam
			  TransformationMemorandam transformationMemorandam = (TransformationMemorandam) dataObject;
			  TransformationMemorandamPDFDocProvider pdfDocProvider = TransformationMemorandamPDFDocProvider.getInstance();
			  pdfDocPath = pdfDocProvider.getTransformationMemorandam(transformationMemorandam, userId);
		  } else if(Constants.PDFDocument.TRANSFORMATION_APPROVAL_NOTICE.equalsIgnoreCase(pdfType)) {
			  // Need to add implementation for Transformation Approval Notice
			  
		  }
	} catch (Exception e) {
		String errorMsg = logTag + "PDF Type given is does not exist";
		log.error(errorMsg);
		throw new BlockbusterException(errorMsg, e);
	}
	return pdfDocPath;
  }
  
  //=========================================================================
}