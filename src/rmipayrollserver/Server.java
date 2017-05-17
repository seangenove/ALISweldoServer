package rmipayrollserver;

import classes.Employee;
import classes.AddEmployee;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.*;
import java.io.*;

// create a class that will give implementation to the interface above (make sure that the class will extend UnicastRemoteObject and implement the interface above)
public class Server extends UnicastRemoteObject implements AddEmployee {
    // required throwing of RemoteException due to the super class constructor

    static HashMap<String, Employee> employees;

    // HashMap <String, String> status = new HashMap<String, String>();
    public Server() throws RemoteException {

    }

    public static void loadHashMap() {
        try {
            File toRead = new File("employees");
            FileInputStream fis = new FileInputStream(toRead);
            ObjectInputStream ois = new ObjectInputStream(fis);

            employees = (HashMap<String, Employee>) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("HashMap for employees has been loaded.");
        } catch (Exception e) {
            employees = new HashMap<String, Employee>();
        }
    }

    public static void saveHashMap(HashMap<String, Employee> map) {
        try {
            File fileOne = new File("employees");
            FileOutputStream fos = new FileOutputStream(fileOne);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("error saving");
            // HashMap <String, Employee> hm = new HashMap<String, Employee>();
        }
    }

    public boolean addEmployee(Employee employee) throws RemoteException {
        try {
            if (employee.getFullName().equals(" ")
                    || Character.toString(employee.getGender()).equals(" ")
                    || employees.containsKey(employee.getFullName())) {
                return false;
            } else {
                employee.setID(Integer.toString(employees.size()+1));
                employees.put(employee.getId(), employee);
                System.out.println("\n"+employees.get(employee.getId()).getFullName()+" just made the list!!!");
                saveHashMap(employees);
                System.out.println("\n List of employees");
                for (Employee emp : employees.values()) {
                    System.out.println(emp.getFullName());
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String login(String id, String password) throws RemoteException {
        try {
            if (id.equals("admin") && password.equals("admin")) {
                return "admin";
            } else {
                Employee employee = employees.get(id);
                if (!(employee == null) && employee.getPassword().equals(password)) {
                    return "success";
                } else {
                    return "mali";
                }
            }
        } catch (Exception e) {
            return "mali";
        }
    }
    
    public double computeSSS(double grossIncome, String operation) throws RemoteException{
        double computedGrossIncome = grossIncome/2;
        double SSS = 0;
        
        if(computedGrossIncome <= 1249.99){
            computedGrossIncome -= 36.30;
            SSS = 36.30;
        }
        
        return 20.00;
    }
//else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }else if(){
//        }
        
        return 20.00;
    }

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "file:./server.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            loadHashMap();
            System.out.println("Employees:");
            for (Employee emp : employees.values()) {
                System.out.println(emp.getId()+" "+emp.getFullName()+" "+emp.getPassword());
            }
            // create instance of class with implementation
            AddEmployee stub = new Server();
            // create a registry class and start/create a running registry
            Registry reg = LocateRegistry.createRegistry(1099);
            // register the instance of class to the registry using a unique name
            reg.rebind("sample", stub);
            System.out.println("\nALIsweldo server is up and running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
