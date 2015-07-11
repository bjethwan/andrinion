package com.andrinion.entities;

import static com.andrinion.entities.HibernateUtil.*;

import java.util.List;

import org.hibernate.Session;
import org.omg.CORBA.PERSIST_STORE;

public class PushSubscriptionManager {
	
	public void persist(PushSubscription pushSubscription){
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		session.save(pushSubscription);
		session.getTransaction().commit();
	}
	
	public PushSubscription query(int deviceId)
	{
		PushSubscription pushSubscription = null;
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		pushSubscription = (PushSubscription)session.load(PushSubscription.class, deviceId);
		session.getTransaction().commit();
		return pushSubscription;
	}

	public List<PushSubscription> listAll()
	{
		List<PushSubscription> list = null;
		Session session = getAppSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from PushSubscription").list();
		session.getTransaction().commit();		
		return list;
	}

	public static void main(String[] args) {
		PushSubscription pushSubscription = new PushSubscription();
		pushSubscription.setDeviceId("imei");
		pushSubscription.setSubscriptionId("subscriptionId");
		
		PushSubscriptionManager pushSubscriptionManager = new PushSubscriptionManager();
		pushSubscriptionManager.persist(pushSubscription);
	}
	
}
