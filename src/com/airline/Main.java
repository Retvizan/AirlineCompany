package com.airline;
import com.airline.airlineclasses.Aircraft;
import com.airline.airlineclasses.Helicopter;
import com.airline.airlineclasses.Plane;
import com.airline.comparator.RangeComparator;
import exceptions.MyOwnException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParserConfigurationException, SAXException {

        ArrayList<Aircraft> belavia = new ArrayList<Aircraft>();
        // add aircrafts stored as objects in file

        addFromFile(belavia);

        //add aircrafts stored in database

        addFromDatabase(belavia);

        // Add elements into airline using xml document

        addFromXmlFile(belavia);

        // Sort by range
        Collections.sort(belavia, new RangeComparator());

        for (int i=0;i<belavia.size();i++){
            System.out.println(belavia.get(i).getName()+ "  " + belavia.get(i).getRange());
        }

// Show Total Range
        try {
            System.out.println("The Total range of the airline is " + countRange(belavia) + "km");
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
            e.getMess();
        }

// Search by parameters

        searchByParameters(belavia);


    }
    //Count Total Range of the airline

    public static int countRange(ArrayList<Aircraft>air) throws MyOwnException {
        int totalRange = 0;
        for (Aircraft i : air) {
            totalRange += i.getRange();
        }
        if(totalRange < 10_000){
            throw new MyOwnException("Not enough range");
        }

        return totalRange;
    }

    /*separate method that can be used for sorting aircrafts by range when not using collection


    private static void sortRange(Aircraft[] belavia) {
            for (int i=0; i<belavia.length; i++){
            Aircraft sort= belavia[i];
            for (int j=i; j<belavia.length; j++){
                if(sort.getRange() > belavia[j].getRange()){
                    belavia[i]=belavia[j];
                    belavia[j]= sort;
                    sort=belavia[i];
                }
            }
        }
 */
// Search by parameters
    private static void searchByParameters(ArrayList<Aircraft> belavia) {
        System.out.println("Please input min range parameter:");
        int rangePar=0;
        int year=0;

        Scanner scanner=new Scanner(System.in);
        try{
            rangePar=scanner.nextInt();

        System.out.println("Please enter min year");

            year = scanner.nextInt();

                    }
        catch(InputMismatchException exception){
            System.out.println("This is not a number");
            System.exit(1);
              }


        for (Aircraft i : belavia){
              if (i.getRange()>=rangePar &&i.getYear()>= year){
              System.out.println("Match " + i.getName() + "  " + i.getRange() + "  " + i.getYear());
          }
        }
    }
    //Add from Xml File
    private static void addFromXmlFile(ArrayList<Aircraft> belavia) throws ParserConfigurationException, SAXException, IOException {
        File xmlfile = new File("D:\\Temp\\Helic.txt");
        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(xmlfile);

        NodeList helic = doc.getElementsByTagName("Helicopter");
        for (int i=0; i<helic.getLength(); i++){
            Node node = helic.item(i);

            if (node.getNodeType()== Node.ELEMENT_NODE){
                Element elem = (Element)node;
                String modelName = elem.getElementsByTagName("modelName").item(0).getTextContent();
                int year = Integer.parseInt(elem.getAttribute("year"));
                int range = Integer.parseInt(elem.getAttribute("range"));
                int cargoweight = Integer.parseInt(elem.getAttribute("cargoweight"));

                Aircraft temp = new Helicopter(modelName, year, range, cargoweight);

                belavia.add(temp);

            }



        }
    }
// Add from Database
    private static void addFromDatabase(ArrayList<Aircraft> belavia) throws SQLException {
        String url ="jdbc:mysql://localhost:3306/retvizan";
        String user="Admin";
        String pass="Qaz1qaz1!";
        String sql="SELECT * FROM `retvizan`.`planes` where `id`= ?;";



        try(
                Connection connection = DriverManager.getConnection(url,user,pass);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            for (int i = 1; i < 3; i++) {
                statement.setInt(1, i);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String modelName = resultSet.getString(2);
                    int year = resultSet.getInt(3);
                    int range = resultSet.getInt(4);
                    int capacity = resultSet.getInt(5);

                    Aircraft temp = new Plane(modelName, year, range, capacity);
                    belavia.add(temp);
                }
            }
        }
    }

    // Add from file, file should be created by running main in AircraftData Class
    private static void addFromFile(ArrayList<Aircraft> belavia) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("d:\\AirlineData\\data.txt");
        ObjectInputStream objin = new ObjectInputStream(in);

        try {
            while (true) belavia.add((Aircraft) objin.readObject());
        }
        catch (EOFException e){
            System.out.println("List of aircrafts sorted by range");
        }
        objin.close();
    }


}




