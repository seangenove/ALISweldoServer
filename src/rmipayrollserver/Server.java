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
        } else if(computedGrossIncome <= 1749.99){
            computedGrossIncome -= 54.50;
            SSS = 54.50;
        } else if(computedGrossIncome <= 2249.99){
            computedGrossIncome -= 72.70;
            SSS = 72.70;
        } else if(computedGrossIncome <= 2749.99){
            computedGrossIncome -= 90.80;
            SSS = 90.80;
        } else if(computedGrossIncome <= 3249.99){
            computedGrossIncome -= 109.00;
            SSS = 109.00;
        } else if(computedGrossIncome <= 3749.99){
            computedGrossIncome -= 127.20;
            SSS = 127.20;
        } else if(computedGrossIncome <= 4249.99){
            computedGrossIncome -= 145.30;
            SSS = 145.30;
        } else if(computedGrossIncome <= 4749.99){
            computedGrossIncome -= 163.50;
            SSS = 163.50;
        } else if(computedGrossIncome <= 5249.99){
            computedGrossIncome -= 181.70;
            SSS = 181.70;
        } else if (computedGrossIncome <= 5749.99){
            computedGrossIncome -= 199.80;
            SSS = 199.80;
        } else if (computedGrossIncome <= 6249.99){
            computedGrossIncome -= 218.00;
            SSS = 218.00;
        } else if (computedGrossIncome <= 6749.99){
            computedGrossIncome -= 236.20;
            SSS = 236.20;
        } else if (computedGrossIncome <= 7249.99){
            computedGrossIncome -= 254.30;
            SSS = 254.30;
        } else if (computedGrossIncome <= 7749.99){
            computedGrossIncome -= 272.50;
            SSS = 272.50;
        } else if(computedGrossIncome <= 8249.99){
            computedGrossIncome -= 290.70;
            SSS = 290.70;
        } else if(computedGrossIncome <= 8749.99){
            computedGrossIncome -= 308.80;
            SSS = 308.80;
        } else if(computedGrossIncome <= 9249.99){
            computedGrossIncome -= 327.00;
            SSS = 327.00;
        } else if(computedGrossIncome <= 9749.99){
            computedGrossIncome -= 345.20;
            SSS = 90.80;
        } else if(computedGrossIncome <= 10249.99){
            computedGrossIncome -= 363.30;
            SSS = 363.30;
        } else if (computedGrossIncome <= 10749.99){
            computedGrossIncome -= 381.50;
            SSS = 381.50;
        } else if(computedGrossIncome <= 12249.99){
            computedGrossIncome -= 436.00;
            SSS = 436.00;
        } else if(computedGrossIncome <= 12749.99){
            computedGrossIncome -= 454.20;
            SSS = 454.20;
        } else if(computedGrossIncome <= 13249.99){
            computedGrossIncome -= 472.30;
            SSS = 472.30;
        } else if(computedGrossIncome <= 13749.99){
            computedGrossIncome -= 490.50;
            SSS = 490.50;
        } else if(computedGrossIncome <= 14249.99){
            computedGrossIncome -= 508.70;
            SSS = 508.70;
        } else if(computedGrossIncome <= 14749.99){
            computedGrossIncome -= 526.80;
            SSS = 526.80;
        } else if(computedGrossIncome <= 15249.99){
            computedGrossIncome -= 545.00;
            SSS = 545.00;
        } else {
            computedGrossIncome -= 563.20;
            SSS = 563.20;
        } 
        
        if (operation.equals("get")) {
            return SSS;
        } else {
            return computedGrossIncome;
        }
    } 
        public double computePhilHealth(double grossIncome, String operation) throws RemoteException{
        double computedPhilHealth = grossIncome/2;
        double philHealth = 0;
        
        if(computedPhilHealth <= 7999.99){
            computedPhilHealth -= 87.50;
            philHealth = 87.50;
        } else if (computedPhilHealth <= 8999.99){
            computedPhilHealth -= 100;
            philHealth = 100;
        } else if (computedPhilHealth <= 9999.99){
            computedPhilHealth -= 112.50;
            philHealth = 112.50;
        } else if (computedPhilHealth <= 10999.99){
            computedPhilHealth -= 125;
            philHealth = 125;
        } else if (computedPhilHealth <= 11999.99){
            computedPhilHealth -= 137.50;
            philHealth = 137.30;
        } else if (computedPhilHealth <= 12999.99){
            computedPhilHealth -= 150;
            philHealth = 150;
        } else if (computedPhilHealth <= 13999.99){
            computedPhilHealth -= 162.50;
            philHealth = 162.50;
        } else if (computedPhilHealth <= 14999.99){
            computedPhilHealth -= 175;
            philHealth = 175;
        } else if (computedPhilHealth <= 15999.99){
            computedPhilHealth -= 187.50;
            philHealth = 187.50;
        } else if (computedPhilHealth <= 16999.99){
            computedPhilHealth -= 200;
            philHealth = 200;
        } else if (computedPhilHealth <= 17999.99){
            computedPhilHealth -= 212.50;
            philHealth = 212.50;
        } else if (computedPhilHealth <= 18999.99){
            computedPhilHealth -= 225;
            philHealth = 225;
        } else if (computedPhilHealth <= 19999.99){
            computedPhilHealth -= 237.50;
            philHealth = 237.50;
        } else if (computedPhilHealth <= 20999.99){
            computedPhilHealth -= 250;
            philHealth = 250;
        } else if (computedPhilHealth <= 21999.99){
            computedPhilHealth -= 262.50;
            philHealth = 262.50;
        } else if (computedPhilHealth <= 22999.99){
            computedPhilHealth -= 275;
            philHealth = 275;
        } else if (computedPhilHealth <= 23999.99){
            computedPhilHealth -= 287.50;
            philHealth = 287.50;
        } else if (computedPhilHealth <= 24999.99){
            computedPhilHealth -= 300;
            philHealth = 300;
        } else if (computedPhilHealth <= 25999.99){
            computedPhilHealth -= 312.50;
            philHealth = 312.50;
        } else if (computedPhilHealth <= 26999.99){
            computedPhilHealth -= 325;
            philHealth = 325;
        } else if (computedPhilHealth <= 27999.99){
            computedPhilHealth -= 337.50;
            philHealth = 337.50;
        } else if (computedPhilHealth <= 28999.99){
            computedPhilHealth -= 350;
            philHealth = 350;
        } else if (computedPhilHealth <= 29999.99){
            computedPhilHealth -= 362.50;
            philHealth = 362.50;
        } else if (computedPhilHealth <= 30999.99){
            computedPhilHealth -= 375;
            philHealth = 375;
        } else if (computedPhilHealth <= 31999.99){
            computedPhilHealth -= 387.50;
            philHealth = 387.50;
        } else if (computedPhilHealth <= 32999.99){
            computedPhilHealth -= 400;
            philHealth = 400;
        } else if (computedPhilHealth <= 33999.99){
            computedPhilHealth -= 412.50;
            philHealth = 412.50;
        } else if (computedPhilHealth <= 34999.99){
            computedPhilHealth -= 425;
            philHealth = 425;
        } else if (computedPhilHealth > 35999.99){
            computedPhilHealth -= 437.50;
            philHealth = 437.50;
        } 
        
        if(operation.equals("get")){
        return computedPhilHealth;
        }else{
            return philHealth;
        }

    }

    public double computePagibig(double grossIncome, String operation)throws RemoteException{
        double computedGrossIncome = grossIncome/2;
        double pagibigDeduction = 0;
        
        // if computedgrossIncome is 1500 below, multiply 0.01 to 
        // computedgrossIncome and deduct that to computedgrossIncome
        // NOTE: ceiling is 100
        
        pagibigDeduction = computedGrossIncome*0.01;
        
        
        // if computedgrossIncome is over 1500, multiply 0.02 to 
        // computedgrossIncome and deduct that to computedgrossIncome
        // NOTE: ceiling is 100
        
        
        
        if(operation.equals("get")){
            return pagibigDeduction;
        }else{
            return computedGrossIncome;
        }
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
