package GUI;
import DB.CarDAO;
import DB.CarDB;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class thread_sem {


    public static class AccesVoiture implements Runnable {

        /**
         * time to wait after acquiring a "rampe"
         */
        TimeUnit unit = null;
        long sleepTime = 0;
        Car car;
        ImageIcon image;
        static boolean notExit = false;
        CarDAO carDAO = null;
        Bar Bar;
        /**
         * Initial Available spaces
         */
        private static int NBR_PLACES = 2;
        private static int NBR_RAMPE = 1;

        /**
         * Semaphores
         */
        private static Semaphore semPlace = new Semaphore(NBR_PLACES, true);
        private static Semaphore semRampe = new Semaphore(NBR_RAMPE, true);
        public AccesVoiture(Car car, long time, TimeUnit unit , Bar Bar) throws SQLException {
            this.Bar = Bar;
            this.unit = unit;
            this.car = car;
            this.sleepTime = time;
            carDAO = new DB.CarDAO();
        }

        /**
         * reference time
         */
        private static final long referenceTime = System.currentTimeMillis();

        private String getAccesVoitureDesc() {
            return "[" + (System.currentTimeMillis() - referenceTime) + "] (Proc : " + Thread.currentThread().getName() + ")";
        }

        public void run() {
            try {
                System.out.println(getAccesVoitureDesc() + " veut rentrer dans le parking !");
                this.entrer_parking();
                System.out.println(getAccesVoitureDesc() + " veut sortir du parking !");
                this.sortir_parking();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }

        }

        public void entrer_parking() throws InterruptedException, SQLException {
            try {
                semPlace.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getAccesVoitureDesc() + " a donné sa carte, ATTENTE");
            try {
                this.unit.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(getAccesVoitureDesc() + " a fini son attente");
            }
            semRampe.acquire();
            Animation.BarDown(this.Bar);
            System.out.println(getAccesVoitureDesc() + " passe sur la rampe");
            semRampe.release();
            Animation.moveIN(this.car, 580);

            Animation.BarUp(this.Bar);
            this.carDAO.saveEnter(this.car);
            Display.reload();
            System.out.println(getAccesVoitureDesc() + " est descendu de la rampe et est garé a sa place !");
            Animation.parking(this.car);

        }

        public void sortir_parking() throws InterruptedException, SQLException {
            this.unit.sleep(5000);
            semRampe.acquire();
            Animation.exitParking(this.car);
            System.out.println(getAccesVoitureDesc() + " passe sur la rampe (pour sortir)");

            semRampe.release();
            Animation.moveOut(this.car);

            System.out.println(getAccesVoitureDesc() + " est descendu de la rampe (pour sortir)");
            semPlace.release();
            System.out.println(getAccesVoitureDesc() + " est sorti du parking...Place liberée !");
            this.carDAO.saveSortie(this.car.car_id);
            Display.reload();
        }

    }

}
