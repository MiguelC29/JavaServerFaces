package modelo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConvertorBasicFormBean {

    ConvertorBasicForm conv = new ConvertorBasicForm();

    public ConvertorBasicForm getConv() {
        return conv;
    }

    public void setConv(ConvertorBasicForm conv) {
        this.conv = conv;
    }
}
