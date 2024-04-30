package modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

public class ConvertorBasicForm {

    private int age;
    private Date date1 = new Date();
    private Date date2 = new Date();
    private Date date3 = new Date();
    private Date date4;

    private BigDecimal bigdecimal = new BigDecimal(32112323.132);
    private Locale locale = Locale.FRANCE;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public BigDecimal getBigdecimal() {
        return bigdecimal;
    }

    public void setBigdecimal(BigDecimal bigdecimal) {
        this.bigdecimal = bigdecimal;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}