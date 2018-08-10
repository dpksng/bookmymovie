package com.bookmymovie.dao.api;

import com.bookmymovie.dao.entity.Admin;

public interface AdminDao {

	public boolean insert(Admin admin);
	public Admin getAdminById(String adminId);

}
