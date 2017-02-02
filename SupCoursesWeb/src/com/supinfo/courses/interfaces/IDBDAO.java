package com.supinfo.courses.interfaces;

import javax.ejb.Remote;

@Remote
public interface IDBDAO {
	public void initDB();
}
