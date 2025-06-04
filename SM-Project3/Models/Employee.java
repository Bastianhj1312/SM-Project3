package Models;


/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee extends Customer
{
   private int staffID;
   
   public Employee(String name, int staffID){
       super(name);
       this.staffID = staffID;
   }
   public int getStaffID(){
       return staffID;
   }
   public void setStaffID(int staffID){
       this.staffID = staffID;
   }
}
