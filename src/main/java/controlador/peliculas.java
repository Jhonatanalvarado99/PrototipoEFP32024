package controlador;

public class Peliculas {
    private String idPeliculas;
    private String nombre_pel;
    private String clasificacion_pel;
    private String subtitulado_pel;
    private String  genero_pel;
    private String  idioma_pel;
    private String precio_pel;

    public Peliculas() {
    }

    @Override
    public String toString() {
        return "Peliculas{" + "idPeliculas=" + idPeliculas + ", nombre_pel=" + nombre_pel + ", clasificacion_pel=" + clasificacion_pel + ", subtitulado_pel=" + subtitulado_pel + ", genero_pel=" + genero_pel + ", idioma_pel=" + idioma_pel + ", precio_pel=" + precio_pel + '}';
    }

    public String getIdPeliculas() {
        return idPeliculas;
    }

    public void setIdPeliculas(String idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getNombre_pel() {
        return nombre_pel;
    }

    public void setNombre_pel(String nombre_pel) {
        this.nombre_pel = nombre_pel;
    }

    public String getClasificacion_pel() {
        return clasificacion_pel;
    }

    public void setClasificacion_pel(String clasificacion_pel) {
        this.clasificacion_pel = clasificacion_pel;
    }

    public String getSubtitulado_pel() {
        return subtitulado_pel;
    }

    public void setSubtitulado_pel(String subtitulado_pel) {
        this.subtitulado_pel = subtitulado_pel;
    }

    public String getGenero_pel() {
        return genero_pel;
    }

    public void setGenero_pel(String genero_pel) {
        this.genero_pel = genero_pel;
    }

    public String getIdioma_pel() {
        return idioma_pel;
    }

    public void setIdioma_pel(String idioma_pel) {
        this.idioma_pel = idioma_pel;
    }

    public String getPrecio_pel() {
        return precio_pel;
    }

    public void setPrecio_pel(String precio_pel) {
        this.precio_pel = precio_pel;
    }

    public Peliculas(String idPeliculas, String nombre_pel) {
        this.idPeliculas = idPeliculas;
        this.nombre_pel = nombre_pel;
    }

    public Peliculas(String idPeliculas, String nombre_pel, String clasificacion_pel, String subtitulado_pel, String genero_pel, String idioma_pel, String precio_pel) {
        this.idPeliculas = idPeliculas;
        this.nombre_pel = nombre_pel;
        this.clasificacion_pel = clasificacion_pel;
        this.subtitulado_pel = subtitulado_pel;
        this.genero_pel = genero_pel;
        this.idioma_pel = idioma_pel;
        this.precio_pel = precio_pel;
    }

    
}