public class Plato implements Comparable <Plato>,Cloneable {
    String nombrePlato;
    double precioPlato;
    double calorias;
    int timepoPreparacion;

    public Plato() {
    }

    public Plato(String nombrePlato, double precioPlato, double calorias, int timepoPreparacion) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.calorias = calorias;
        this.timepoPreparacion = timepoPreparacion;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getTimepoPreparacion() {
        return timepoPreparacion;
    }

    public void setTimepoPreparacion(int timepoPreparacion) {
        this.timepoPreparacion = timepoPreparacion;
    }
    public int compareTo(Plato o) {
        int comparedResult=nombrePlato.compareTo(o.nombrePlato);
        if(comparedResult>0){
            return 1;
        } else if (comparedResult<0) {
            return -1;
        } else {
            return 0;
        }
    }
    public Plato deepClone() throws CloneNotSupportedException{
        Plato clone=(Plato) super.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombrePlato='" + nombrePlato + '\'' +
                ", precioPlato=" + precioPlato +
                ", calorias=" + calorias +
                ", timepoPreparacion=" + timepoPreparacion +
                '}';
    }
}
