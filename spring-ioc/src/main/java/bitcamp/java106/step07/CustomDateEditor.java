package bitcamp.java106.step07;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class CustomDateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("CustomDateEditor.setAsText()");
        this.setValue(Date.valueOf(text));
    }
    
    @Override
    public void setValue(Object value) {
        System.out.println("CustomDateEditor.setValue()");
        super.setValue(value);
    }
    
    @Override
    public Object getValue() {
        System.out.println("CustomDateEditor.getValue()");
        return super.getValue();
    }
}
