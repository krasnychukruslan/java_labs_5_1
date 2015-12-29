package tests;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab5src.Person;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author yushana
 */
public class PersonTest {
    
    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Person p=new Person("Oleh", "Yushko", "Victorovich", new GregorianCalendar(1994,7,21));
        boolean result = p.equals(p);
        assertEquals(true, result);
    }
    @Test
    public void testSerializeDeserialize() throws IOException,ClassNotFoundException{
        System.out.println("SerializeDeserialize");
        Person p=new Person("Oleh", "Yushko", "Victorovich", new GregorianCalendar(1994,7,21));
        ByteArrayOutputStream str=new ByteArrayOutputStream();
        p.serialize(str);
        //str.
        //InputStream inp=new ByteArrayInputStream();
        
        Person instance=Person.deserialize(new ByteArrayInputStream(str.toByteArray()));
        boolean result = p.equals(instance);
        assertEquals(true, result);
    }
    
}
