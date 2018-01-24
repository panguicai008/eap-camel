package org.test.case1;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//文件复制
		from("file:src/data?noop=true")
//			.choice()
//			.when(xpath("/person/city = 'London'"))
//	        .to("file:target/messages/uk")
//	        .otherwise()
	        .to("file:target/messages/others");
		
	}

}
