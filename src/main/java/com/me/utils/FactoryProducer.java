package com.me.utils;

import com.me.factory.AbstractFactory;
import com.me.factory.IDAOFactory;
import com.me.factory.ServiceFactory;
/**
 * 
 * @author fenghere
 *
 */

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {
		if(choice.equals("idao")) {
			return new IDAOFactory();
		}else if (choice.equals("service")) {
			return new ServiceFactory();
		}
		return null;
	}
}
