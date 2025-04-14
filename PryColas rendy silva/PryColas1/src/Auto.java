public class Auto {
    private String marca;
    private int anio;

    public Auto(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double calcularTotal() {
        int diferencia = 2025 - this.anio;
        if (diferencia < 0) {
            return 0;
        }
        return diferencia * 50;
    }

    @Override
    public String toString() {
        return "\n---Auto---\n" +
                "Marca: " + marca +
                "\t Año: " + anio +
                "\n Total a pagar hasta 2025: " + calcularTotal();
    }
}

