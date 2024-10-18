package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un
     * Project
     * en un Pillar en el sistema
     */
    public void registerProject() {

        reader.nextLine();

        System.out.println("Digite el pillar de su proyecto" + "\n" +
                "1.Biodiversidad" + "\n" +
                "2.Agua" + "\n" +
                "3.Tratamiento de Basuras" + "\n" +
                "4.Energia");

        int pillarType = reader.nextInt();

        reader.nextLine();

        System.out.println("Digite el ID del proyecto");
        String id = reader.nextLine();

        System.out.println("Digite el nombre del proyecto");
        String name = reader.nextLine();

        System.out.println("Digite la descripcion del proyecto");
        String description = reader.nextLine();

        System.out.println("Digite el estado del proyecto" + "\n" +

                "1.Activo" + "\n" +
                "2.Inactivo");

        int statusUser = reader.nextInt();

        if (control.registerProjectInPillar(pillarType, id, name, description, statusUser)) {
            System.out.println("Registrado Exitosamente");
        } else {
            System.out.println("No se ha podido registrar,pilares llenos");
        }

    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     */
    public void showProjectsByPillar() {
        System.out.println("Proporcione el pilar del cual deseas ver sus proyectos");
        System.out.println("1) Biodiversidad");
        System.out.println("2) Agua");
        System.out.println("3) Tratamiento de Basuras");
        System.out.println("4) Energía");
        int pilar = reader.nextInt();
        reader.nextLine();
        if (pilar <= 4 && pilar >= 1) {
            System.out.println(control.queryProjectsByPillar(pilar));
        } else {
            System.out.println("Valor de pilar invalido!");
        }

    }

}