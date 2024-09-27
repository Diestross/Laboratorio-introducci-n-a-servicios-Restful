package co.edu.unipiloto.ws.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author carva
 */
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age", "salario"})
public class Person {
    private int id;
    private String fullName;
    private int age;
    private double salario;
    
    private static final double SALARIO_MINIMO = 1000000;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Person(){    
    }
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    private double calcularSalario() {
        return (this.age * SALARIO_MINIMO) / 3;
    }
    
}
