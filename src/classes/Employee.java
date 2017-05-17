package classes;

import java.io.*;

public class Employee implements Serializable {
        private char gender;
        private String id;
        private String password;
        private String lastName;
        private String firstName;
        private String birthDate;
        private String jobPosition;
        private String civilStatus;
        private int noOfChildren;
        private String payPeriod;
        
        public Employee() {
        }
        // public Employee(String n, char g) {
        //         this.name = n;
        //         this.gender = g;
        // }
        
        public String getId() {
                return this.id;
        }
        public String getPassword() {
                return this.password;
        }
        public String getLastName() {
                return this.lastName;
        }
        public String getFirstName() {
                return this.firstName;
        }
        public String getFullName() {
                return this.lastName+", "+this.firstName;
        }
        public char getGender() {
                return this.gender;
        }
        public String getBirthDate() {
                return this.birthDate;
        }
        public String getJobPosition() {
                return this.jobPosition;
        }
        public String getCivilStatus() {
                return this.civilStatus;
        }
        public int getNoOfChildren() {
                return this.noOfChildren;
        }
        public String getPayPeriod() {
                return this.payPeriod;
        }

        // setters
        public void setID(String id){
            this.id = id;
        }
        public void setPassword(String password){
            this.password = password;
        }
        public void setLastName(String lname) {
                this.lastName = lname;
        }
        public void setFirstName(String fname) {
                this.firstName = fname;
        }
        public void setGender(char gen) {
                this.gender = gen;
        }
        public void setBirthDate(String bDate) {
                this.birthDate = bDate;
        }
        public void setJobPosition(String jobPos) {
                this.jobPosition = jobPos;
        }
        public void setCivilStatus(String civilStat) {
                this.civilStatus = civilStat;
        }
        public void setNoOfChildren(int noOfChild) {
                this.noOfChildren = noOfChild;
        }
        public void setPayPeriod(String payPer) {
                this.payPeriod = payPer;
        }
}