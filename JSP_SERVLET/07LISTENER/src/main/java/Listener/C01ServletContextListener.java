package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class C01ServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[LISTENER] ServletContextListener..start..");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[LISTENER] ServletContextListener..end..");
	}
	
}
