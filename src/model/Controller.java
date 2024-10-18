package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energia");

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Project en el Pillar, false en
     *         caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, int statusUser) {
        boolean status = false;
        switch (statusUser) {
            case 1:
                status = true;
                break;
            case 2:
                status = false;
            default:
                status = true;
                break;
        }
        Project projectUser = new Project(id, name, description, status);
        Pillar pillar = null;
        for (int i = 0; i < pillars.length; i++) {
            if (pillars[pillarType - 1] != null) {
                pillar = pillars[pillarType - 1];
            }

        }
        return pillar.registerProject(projectUser);
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     *         Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        String list = "";
        switch (pillarType) {
            case 1:
                list = pillars[0].getProjectList();
                break;
            case 2:
                list = pillars[1].getProjectList();
                break;
            case 3:
                list = pillars[2].getProjectList();
                break;
            case 4:
                list = pillars[3].getProjectList();
                break;
        }

        return list;

    }

}