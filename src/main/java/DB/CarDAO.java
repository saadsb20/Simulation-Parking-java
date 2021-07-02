package DB;
import GUI.Car;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;


public class CarDAO {
    private Connection cnx ;
    private Statement statement ;
    private PreparedStatement preparedStatement ;

    private String url = "jdbc:mysql://127.0.0.1:3306/cars" ;
    private String user = "root";
    private String  password = "";
    private ResultSet resultSet ;

    public CarDAO() throws SQLException {
        this.cnx = DriverManager.getConnection(url, user, password);
    }

    public  boolean saveEnter(Car object)  throws SQLException {
        try{
            String rq = "INSERT INTO `cars`(`car_id`, `situation`, `time_entrer`) VALUES (?,?,?)" ;

            this.preparedStatement = this.cnx.prepareStatement(rq);

            this.preparedStatement.setInt(1, object.getCarId());
            this.preparedStatement.setBoolean(2, true);
            this.preparedStatement.setTime(3, Time.valueOf(LocalTime.now()));

            this.preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    public boolean saveSortie(Integer car_id)  throws SQLException{
        try {
            String re = "UPDATE `cars` SET `situation`=?,`time_sortie`=? WHERE car_id =" + car_id;
            this.preparedStatement = this.cnx.prepareStatement(re);

            this.preparedStatement.setBoolean(1, false);
            this.preparedStatement.setTime(2, Time.valueOf(LocalTime.now()));

            this.preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    public ArrayList<CarDB> getAll()  throws SQLException{

        ArrayList<CarDB> lis = new ArrayList() ;
        String re = "select * from cars";

        this.statement = this.cnx.createStatement();
        this.resultSet = this.statement.executeQuery(re);

        while (this.resultSet.next()) {
            lis.add(new CarDB(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getBoolean(3), this.resultSet.getTime(4), this.resultSet.getTime(5)));
        }
        return lis;
    }








}
