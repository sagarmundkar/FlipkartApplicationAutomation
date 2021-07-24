package com.flipkart.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestReadPdfFile {

    @Test
    public void readPdfFile() throws IOException {

        URL url = new URL("file:///C:/Users/Administrator/Downloads/employee-information-form-download-20170810.pdf");
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        PDDocument document = null;

        document = PDDocument.load(bufferedInputStream);
        String pdfContent = new PDFTextStripper().getText(document);
        System.out.println(pdfContent);

        Assert.assertTrue(pdfContent.contains("Company Name"));
        Assert.assertTrue(pdfContent.contains("Employee Information"));
        Assert.assertTrue(pdfContent.contains("Address"));
    }
}
