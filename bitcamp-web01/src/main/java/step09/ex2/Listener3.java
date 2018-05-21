package step09.ex2;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener3 implements ServletRequestAttributeListener {
    
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("Listener3.attributeAdded()");
        System.out.printf("%s=%s 저장\n", srae.getName(), srae.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("Listener3.attributeReplaced()");
        System.out.printf("%s=%s(%s) 변경\n",
                srae.getName(),
                srae.getServletRequest().getAttribute(srae.getName()),
                srae.getValue());
    }
}
