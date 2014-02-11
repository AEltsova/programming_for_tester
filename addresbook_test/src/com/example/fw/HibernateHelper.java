package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.InitGroupParameter;
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager linkToAM) {
	  super(linkToAM);
	}

	
	public SortedListOf<InitGroupParameter> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<InitGroupParameter>(
              (List<InitGroupParameter>) session.createQuery("from InitGroupParameter").list());
		} finally {
          trans.commit();
		}
	}
}
