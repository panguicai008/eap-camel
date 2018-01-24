package org.test.case1;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class Scheduler extends Main{
	public static void main(String[] args){
		Scheduler scheduler=new Scheduler();
		scheduler.enableHangupSupport();
		scheduler.bind("processByBean1", new MainApp());
		scheduler.bind("processAgainByBean2", new File2Db());
		scheduler.addRouteBuilder(createRouteBuilder());
		try {
			scheduler.run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	static RouteBuilder createRouteBuilder() {  
		return new RouteBuilder(){
			public void configure() {  
				from("timer://timer1?period=1000")  
				.to("bean:processByBean1")  
				.to("bean:processAgainByBean2");  
			} 
		};
	}  
}
