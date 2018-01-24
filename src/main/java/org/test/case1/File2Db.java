package org.test.case1;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class File2Db {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) throws Exception {
		final String url = "jdbc:mysql://localhost:3306;databaseName=fuse";

        DataSource datasource = setupDataSource(url);
        SimpleRegistry simpleregistry = new SimpleRegistry();
        simpleregistry.put("DataSource", datasource);
        CamelContext context = new DefaultCamelContext(simpleregistry);
        context.addRoutes(new File2Db().new MyRouteBuilder());

        context.start();
        Thread.sleep(20000);
        context.stop();

	}
	class MyRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            try {

                from("direct:a_cms_dept")
                .setBody(constant("INSERT INTO a_cms_dept(COMPANY_CODE,DEPT_CODE,DEPT_NAME,CREATE_DATE,LAST_UPDATE) VALUES('1234','4567','1211','2014-08-13 05:08:17','2014-08-13 05:08:17')")) 
                .to("jdbc:DataSource");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
	class TimerRouteBuilder extends RouteBuilder{

		@Override
		public void configure() throws Exception {
			from("timer://timer1?period=1000")
				.process(new Processor() { 
					public void process(Exchange msg) { 
						logger.info("Processing {}", msg); 
					} 
				}); 
			
		}
		
	}
    private static DataSource setupDataSource(String url){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setUrl(url);
        return basicDataSource;
    }

}
