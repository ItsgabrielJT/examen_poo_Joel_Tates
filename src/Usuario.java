public class Usuario extends Persona
{
    private double dinero;

    public Usuario(String nombre, String apellido, String cedula, int edad, double dinero) {
        super(nombre, apellido, cedula, edad);
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }


    @Override
    public String toString() {
        return super.toString() + dinero + '\n' + "-1";
    }
}
