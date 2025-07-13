package es.cresdev.patterns.builder.informes;

import lombok.Getter;
import java.util.List;
import java.util.Collections;

@Getter
public class InformeTecnico {

    private final String titulo;
    private final String autor;
    private final String fecha;
    private final String resumen;
    private final String contenido;
    private final List<String> anexos;
    private final String firma;

    private InformeTecnico(Builder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.fecha = builder.fecha;
        this.resumen = builder.resumen;
        this.contenido = builder.contenido;
        this.anexos = builder.anexos != null ? builder.anexos : Collections.emptyList();
        this.firma = builder.firma;
    }

    public static class Builder {

        private final String titulo;
        private final String contenido;

        private String autor;
        private String fecha;
        private String resumen;
        private List<String> anexos;
        private String firma;

        public Builder(String titulo, String contenido) {
            if (titulo == null || titulo.isBlank()) {
                throw new IllegalStateException("El título es obligatorio");
            }
            if (contenido == null || contenido.isBlank()) {
                throw new IllegalStateException("El contenido es obligatorio");
            }
            this.titulo = titulo;
            this.contenido = contenido;
        }

        public Builder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public Builder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder resumen(String resumen) {
            this.resumen = resumen;
            return this;
        }

        public Builder anexos(List<String> anexos) {
            this.anexos = anexos;
            return this;
        }

        public Builder firma(String firma) {
            this.firma = firma;
            return this;
        }

        public InformeTecnico build() {
            return new InformeTecnico(this);
        }
    }
}