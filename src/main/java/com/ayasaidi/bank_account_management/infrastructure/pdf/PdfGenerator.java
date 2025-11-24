package com.ayasaidi.bank_account_management.infrastructure.pdf;

import com.ayasaidi.bank_account_management.domain.model.Transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfGenerator {

    public static ByteArrayInputStream generateAccountStatement(List<Transaction> transactions) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("Relevé de compte",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.addCell("Date");
            table.addCell("De");
            table.addCell("Vers");
            table.addCell("Montant");
            table.addCell("Devise");

            for (Transaction t : transactions) {
                table.addCell(t.getDate().toString());
                table.addCell(t.getSenderAccountId().toString());
                table.addCell(t.getReceiverAccountId().toString());
                table.addCell(t.getAmount().toString());
                table.addCell(t.getToCurrency());
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
