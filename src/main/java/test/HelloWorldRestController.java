package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.model.Utenti;

@RestController
public class HelloWorldRestController {
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
 
    private SessionFactory buildSessionFactory() 
    {
    	Configuration configObj = new Configuration();
    	configObj.configure();
    	
    	ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
    	
    	SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
    	return sessionFactoryObj;
    }
    
    @RequestMapping("/list")
    public Result list() {//REST Endpoint.
    	Result r = new Result();
    	
    	Session sessionObj = buildSessionFactory().openSession();
    	Query q = sessionObj.getNamedQuery("Utenti.findAll");
    	@SuppressWarnings("unchecked")
		List<Utenti> l = q.list();
    	
    	List<Message> messages = new ArrayList<Message>();
    	
    	for(Utenti u : l)
    	{
    		Message m = new Message(u.getNome(), u.getCognome());
    		messages.add(m);
    	}   
    	
    	r.setMessages(messages.toArray(new Message[0]));
    	
    	return r;
    }
    
    @RequestMapping("/hello/{name}/{surName}")
    public Message message(@PathVariable String name, @PathVariable String surName) {//REST Endpoint.
        Message msg = new Message(name, surName);
        
        Session sessionObj = buildSessionFactory().openSession();
        
        Utenti u = new Utenti();
        u.setNome(msg.getName());
        u.setCognome(msg.getSurName());
       
        sessionObj.beginTransaction();
        sessionObj.save(u);
        sessionObj.getTransaction().commit();

        return msg;
    }
}
