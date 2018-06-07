package kh_dao;

import java.sql.Connection;
import java.util.List;

import kh_infos.DeliverInfo;
import kh_infos.PuacherListInfo;

public interface ServicePatton {
	public Connection connect();
	public boolean excute1(PuacherListInfo pli , DeliverInfo dio) throws Exception; 
	//public int exCute2();
}
