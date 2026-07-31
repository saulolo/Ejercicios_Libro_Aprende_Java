package uni9_POO.Teoria.disco;

public class Disco {

    private String codigo = "LIBRE";
    private String autor;
    private String titulo;
    private String genero;
    private int duracion;

    public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return String.format(
                "╔════════════════════════════════════════╗" +
                        "\n║🔖Código   : %-26s ║" +
                        "\n║👤Autor    : %-26s ║" +
                        "\n║💿Título   : %-26s ║" +
                        "\n║🎸Género   : %-26s ║" +
                        "\n║⏱Duración  : %-26d ║" +
                        "\n╚════════════════════════════════════════╝",
                codigo, autor, titulo, genero, duracion
        );
    }
}
