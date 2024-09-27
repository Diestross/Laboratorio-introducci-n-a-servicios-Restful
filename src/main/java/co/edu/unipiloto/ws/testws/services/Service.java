/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.services;

import co.edu.unipiloto.ws.testws.entidad.Person;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author carva
 */
@Path("service")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            persons.put(id, person);
        }
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getAllPersonInXML")
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Person> getAllPersonInXML() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/getAllPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getAllPersonInJson() {
        return new ArrayList<Person>(persons.values());
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        persons.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getSalarioPromedioXML")
    @Produces(MediaType.APPLICATION_XML)
    public double getSalarioPromedioXML() {
        double sumaSalarios = 0;
        for (Person person : persons.values()) {
            sumaSalarios += person.getSalario();
        }
        return sumaSalarios / persons.size();
    }

    @GET
    @Path("/getSumaSalariosJson")
    @Produces(MediaType.APPLICATION_JSON)
    public double getSumaSalariosJson() {
        double sumaSalarios = 0;
        for (Person person : persons.values()) {
            sumaSalarios += person.getSalario();
        }
        return sumaSalarios;
    }
    
}
