package com.perfecciondigital.tallerprimefaces.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.api.UIData;
import org.primefaces.component.celleditor.CellEditor;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.primefaces.component.export.ExcelExporter;

public class CustomExcelExporter extends ExcelExporter {

    @Override
    protected void exportCells(DataTable table, Object document) {
        super.exportCells(table, document);

        Workbook wb = (Workbook) document;
        Sheet sheet = wb.getSheetAt(0);

        // Iterate over the rows in the sheet and check for CellEditor components
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    String cellValue = cell.getStringCellValue();
                    UIComponent component = table.findComponent(cellValue);
                    if (component instanceof CellEditor) {
                        // Get the edited value from the CellEditor component
                        CellEditor cellEditor = (CellEditor) component;
                        String editedValue = (String) cellEditor.getSubmittedValue();
                        if (editedValue != null) {
                            // Replace the cell value with the edited value
                            cell.setCellValue(editedValue);
                        }
                    }
                }
            }
        }
    }
    
    protected void exportCell(FacesContext context, UIComponent component, Object value) throws IOException {
        if (component instanceof CellEditor) {
            CellEditor editor = (CellEditor) component;
            UIInput input = (UIInput) editor.getFacet("input");
            if (input.getSubmittedValue() != null) {
                value = input.getSubmittedValue().toString();
            } else {
                value = editor.getValue();
            }
        }
        // Export the value to Excel
        // ...
    }
}
