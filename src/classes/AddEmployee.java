/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.rmi.*;
/**
 *
 * @author SD
 */
public interface AddEmployee extends Remote{
    public boolean addEmployee(Employee e) throws RemoteException;
    public String login(String id, String password) throws RemoteException;
}
