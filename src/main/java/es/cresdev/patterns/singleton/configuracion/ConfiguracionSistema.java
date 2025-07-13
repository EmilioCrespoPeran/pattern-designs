package es.cresdev.patterns.singleton.configuracion;

public class ConfiguracionSistema {

    private static ConfiguracionSistema instance = null;

    private String idioma;
    private String zonaHoraria;
    private String tema;

    private ConfiguracionSistema() {
        configuracionPorDefecto();
    }

    private void configuracionPorDefecto() {
        idioma = "ES";
        zonaHoraria = "+1";
        tema = "oscuro";
    }

    public static ConfiguracionSistema getInstance() {
        if (instance == null) {
            instance = new ConfiguracionSistema();
        }
        return instance;
    }

    public void mostrarConfiguracion() {
        System.out.println("===== Configuracion =====");
        System.out.printf("Idioma: %s\n", idioma);
        System.out.printf("Zona horaria: %s%n", zonaHoraria);
        System.out.printf("Tema: %s%n", tema);
        System.out.println("=========================");
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}
