import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100;
    private static boolean hayGanador = false;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanciaRecorrida < DISTANCIA_META && !hayGanador) {

            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            System.out.println(nombre + " avanza " + avance + " unidades. Total: " + distanciaRecorrida + "/" + DISTANCIA_META);

            if (distanciaRecorrida >= DISTANCIA_META && !hayGanador) {
                    hayGanador = true;
                    System.out.println("¡" + nombre + " ha ganado la carrera!");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
