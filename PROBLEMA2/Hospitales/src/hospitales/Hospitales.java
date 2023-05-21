package hospitales;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ciudad {
    private String nombre;
    private String provincia;

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre + "\nProvincia: " + provincia;
    }
}

class Medico {
    private String nombre;
    private String especialidad;
    private double sueldoMensual;

    public Medico(String nombre, String especialidad, double sueldoMensual) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + especialidad;
    }
}

class Enfermero {
    private String nombre;
    private String tipo;
    private double sueldoMensual;

    public Enfermero(String nombre, String tipo, double sueldoMensual) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + tipo;
    }
}

class Entidad{
    private String nombreHospital;
    private Ciudad ciudad;
    private int numeroEspecialidades;
    private List<Medico> medicos;
    private List<Enfermero> enfermeros;

    public Entidad(String nombreHospital, Ciudad ciudad, int numeroEspecialidades,
                               List<Medico> medicos, List<Enfermero> enfermeros) {
        this.nombreHospital = nombreHospital;
        this.ciudad = ciudad;
        this.numeroEspecialidades = numeroEspecialidades;
        this.medicos = medicos;
        this.enfermeros = enfermeros;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public int getNumeroEspecialidades() {
        return numeroEspecialidades;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public double getTotalSueldos() {
        double total = 0.0;
        for (Medico medico : medicos) {
            total += medico.getSueldoMensual();
        }
        for (Enfermero enfermero : enfermeros) {
            total += enfermero.getSueldoMensual();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreHospital).append("\n");
        sb.append("Dirección: ").append("Barrio Central").append("\n");
        sb.append(ciudad).append("\n");
        sb.append("Número de especialidades: ").append(numeroEspecialidades).append("\n");
        sb.append("Listado de médicos:\n");
        for (Medico medico : medicos) {
            sb.append(medico).append("\n");
        }
        sb.append("\nListado de enfermeros(as):\n");
        for (Enfermero enfermero : enfermeros) {
            sb.append(enfermero).append("\n");
        }
        sb.append("\nTotal de sueldos a pagar por mes: ").append(getTotalSueldos());
        return sb.toString();
    }
}

class Hospitales  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();

        System.out.println("Ingrese la ciudad del hospital: ");
        String nombreCiudad = scanner.nextLine();

        System.out.println("Ingrese la provincia de la ciudad: ");
        String provinciaCiudad = scanner.nextLine();

        System.out.println("Ingrese el número de especialidades: ");
        int numeroEspecialidades = scanner.nextInt();
        scanner.nextLine();

        List<Medico> medicos = new ArrayList<>();
        System.out.println("Ingrese los médicos del hospital: ");
        while (true) {
            System.out.println("Ingrese el nombre del médico (o escriba 'fin' para terminar): ");
            String nombreMedico = scanner.nextLine();
            if (nombreMedico.equals("fin")) {
                break;
            }

            System.out.println("Ingrese la especialidad del médico: ");
            String especialidadMedico = scanner.nextLine();

            System.out.println("Ingrese el sueldo mensual del médico: ");
            double sueldoMedico = scanner.nextDouble();
            scanner.nextLine();

            medicos.add(new Medico(nombreMedico, especialidadMedico, sueldoMedico));
        }

        List<Enfermero> enfermeros = new ArrayList<>();
        System.out.println("Ingrese los enfermeros(as) del hospital: ");
        while (true) {
            System.out.println("Ingrese el nombre del enfermero/enfermera (o escriba 'fin' para terminar): ");
            String nombreEnfermero = scanner.nextLine();
            if (nombreEnfermero.equals("fin")) {
                break;
            }

            System.out.println("Ingrese el tipo del enfermero/enfermera (nombramiento/contrato): ");
            String tipoEnfermero = scanner.nextLine();

            System.out.println("Ingrese el sueldo mensual del enfermero/enfermera: ");
            double sueldoEnfermero = scanner.nextDouble();
            scanner.nextLine();

            enfermeros.add(new Enfermero(nombreEnfermero, tipoEnfermero, sueldoEnfermero));
        }

        Ciudad ciudad = new Ciudad(nombreCiudad, provinciaCiudad);
        Entidad entidadHospitalaria = new Entidad(nombreHospital, ciudad, numeroEspecialidades,
                medicos, enfermeros);

        System.out.println(entidadHospitalaria.toString());
    }
}
