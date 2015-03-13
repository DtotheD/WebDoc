package controller;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Utility-Klasse als Alternative zur @EJB Dependency Injection.
 */
public class BeanFactory
{
    /** Aktuelle Session Fassade für die Verwaltung von User-Entities über JNDI. */
    public static CL_Symptom_Bean sm_getSymptomBean()
    {
        CL_Symptom_Bean bean = null;
        try
        {
            InitialContext ctx = new InitialContext();
            bean = (CL_Symptom_Bean) ctx.lookup("java:global/WebDoc_2015/WebDoc_2015-ejb/CL_Symptom_Bean!controller.IN_Symptom_Bean");
        }
        catch (NamingException ex)
        {
            ex.printStackTrace();
        }
        return bean;
    }
}
