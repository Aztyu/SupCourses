package com.supinfo.courses.interfaces;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface IDbDAO {
	public void initDB();
}