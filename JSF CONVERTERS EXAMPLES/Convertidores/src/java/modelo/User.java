package modelo;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class User {
    String name;
    Integer age;
    Date dob;
    int shirtPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getShirtPrice() {
        return shirtPrice;
    }

    public void setShirtPrice(int shirtPrice) {
        this.shirtPrice = shirtPrice;
    }
}
