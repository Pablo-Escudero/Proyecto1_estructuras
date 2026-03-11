package modelos;

public class Fotografo extends Persona {

    private static final long serialVersionUID = 1L;

    private String especialidad;
    private int anosExperiencia;

    public Fotografo(String nombre, String identificacion, String contacto,
                     String especialidad, int aniosExperiencia) {

        super(nombre, identificacion, contacto);
        this.especialidad = especialidad;
        this.anosExperiencia = aniosExperiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    @Override
    public String mostrarInformacion() {
        return nombre + " | Especialidad: " + especialidad +
                " | Experiencia: " + anosExperiencia;
    }

}