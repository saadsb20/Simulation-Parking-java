package DB;
import java.sql.Time;
public class CarDB {
    private int id;
    private int car_id;
    private Boolean situation;
    private Time time_entrer;
    private Time time_sortie;


    public CarDB(int id, int car_id, Boolean situation, Time time_entrer, Time time_sortie) {
        this.id = id;
        this.car_id = car_id;
        this.situation = situation;
        this.time_entrer = time_entrer;
        this.time_sortie = time_sortie;
    }

    public int getId() {
        return id;
    }

    public int getCar_id() {
        return car_id;
    }

    public Boolean getSituation() {
        return situation;
    }

    public Time getTime_entrer() {
        return time_entrer;
    }

    public Time getTime_sortie() {
        return time_sortie;
    }

    @Override
    public String toString() {
        return "CarDB{" +
                "id=" + id +
                ", car_id=" + car_id +
                ", situation=" + situation +
                ", time_entrer=" + time_entrer +
                ", time_sortie=" + time_sortie +
                '}';
    }
}
