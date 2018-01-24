package org.test.case1;

import org.apache.camel.main.Main;

public class MainApp {

	public static void main(String[] args) {
		Main main = new Main();
	    main.enableHangupSupport();
	    main.addRouteBuilder(new MyRouteBuilder());
	    try {
			main.run(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
