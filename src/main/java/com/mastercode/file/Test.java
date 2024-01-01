package com.mastercode.file;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.objects.SourceType;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Pdf pdf = new Pdf();
        pdf.addPage("https://www.google.com", SourceType.url);
        pdf.saveAs("output.pdf");
    }
}
