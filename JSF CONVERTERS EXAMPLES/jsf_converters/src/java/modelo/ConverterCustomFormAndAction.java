package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "converterCustomFormAndAction")
@SessionScoped
public class ConverterCustomFormAndAction {

    private String creditCardNumber = "1234567812345678";

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String submit() {
        System.out.println("Inside Submit");
        System.out.println("CCno=" + this.creditCardNumber);
        return "covertersCustom";
    }
}