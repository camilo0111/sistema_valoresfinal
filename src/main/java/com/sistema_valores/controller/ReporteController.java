package com.sistema_valores.controller;

import com.sistema_valores.dto.ReporteConductor;
import com.sistema_valores.service.ReporteConductorService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ReporteController {

    @Autowired
    private ReporteConductorService service;

    @GetMapping("/reporte-conductor")
    public String mostrarReporte(Model model) {
        List<ReporteConductor> datos = service.obtenerReporte();
        model.addAttribute("reportes", datos);
        return "reporteConductor";
    }

    @GetMapping("/reporte/pdf")
    public void descargarPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_conductor.pdf");

        List<ReporteConductor> datos = service.obtenerReporte();

        // Usa PDFBox, iText, Jasper o simple texto con OutputStream (opcional: usar
        // biblioteca)
        try (OutputStream out = response.getOutputStream()) {
            out.write(("Reporte de Conductores\n\n").getBytes());
            for (ReporteConductor r : datos) {
                String linea = String.format("%s | %s | %s | %s | %s | %s | %s\n",
                        r.getCodigoSolicitud(), r.getNitEntidad(), r.getNombreEntidad(), r.getFechaYHoraSolicitud(),
                        r.getFechaRealizado(), r.getValor(), r.getDireccionEntidad());
                out.write(linea.getBytes());
            }
        }
    }

    @GetMapping("/reporte/excel")
    public void descargarExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_conductor.xls");

        List<ReporteConductor> datos = service.obtenerReporte();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("Código\tNIT Entidad\tNombre Entidad\tDía\tFecha y Hora\tValor\tDirección");
            for (ReporteConductor r : datos) {
                writer.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s%n",
                        r.getCodigoSolicitud(), r.getNitEntidad(), r.getNombreEntidad(),
                        r.getFechaYHoraSolicitud(), r.getFechaRealizado(), r.getValor(), r.getDireccionEntidad());
            }
        }
    }
}
