/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5src;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author yushana
 */
public class Person implements Serializable{
    private String Guid;
    private String Name;
    private String Surname;
    private String Patronymic;
    private GregorianCalendar BirdDate;
    public Person(String name,String surname,String patronymic,GregorianCalendar birdDate){
        Name=name;
        Surname=surname;
        Patronymic=patronymic;
        BirdDate=birdDate;
        Guid=java.util.UUID.randomUUID().toString();
    }
    public String getName(){
        return Name;
    }
    public String getSurname(){
        return Surname;
    }
    public String getPatronymic(){
        return Patronymic;
    }
    public GregorianCalendar getBirdDate(){
        return BirdDate;
    }
    public void serialize(OutputStream stream) throws IOException {
    try {
        //FileOutputStream f = new FileOutputStream (stream);
        ObjectOutputStream s = new ObjectOutputStream (stream);
        s.writeObject (this);
        //s.close ();
    } catch (IOException e) {
        throw e;
    }
}
public static Person deserialize(InputStream stream) throws IOException,ClassNotFoundException {
    //FileInputStream fis = new FileInputStream(filename);
   ObjectInputStream ois = new ObjectInputStream(stream);
   return (Person)ois.readObject();
}
    public boolean equals(Person p){
        return (Name.equals(p.Name)&&Surname.equals(p.Surname)
                &&Patronymic.equals(p.Patronymic)
                &&BirdDate.equals(p.BirdDate)&&Guid.equals(p.Guid));
    }
}

