package org.test.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Sender {

	public static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();          
	    ConnectionFactory connectionFactory =   
	        new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");  
	    context.addComponent("jms",  
	        JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));  
	    
	    try {
			context.addRoutes(new RouteBuilder() {  
			    public void configure() {                  
			        from("file:src/data").to(  
			        "jms:queue:queue6?jmsMessageType=Text");  
			    }  
			});
			context.start();  
			boolean loop = true;  
		    while (loop) {  
		        Thread.sleep(25000);  
		    }  
			context.stop();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   

	}

}
