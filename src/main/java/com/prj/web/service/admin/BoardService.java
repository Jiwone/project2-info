package com.prj.web.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prj.web.dao.FreeDao;
import com.prj.web.dao.InfoDao;
import com.prj.web.entity.Free;
import com.prj.web.entity.Info;

public class BoardService {
	
	@Autowired
	private FreeDao freeDao;
	
	@Autowired
	private InfoDao infoDao;
	
	public List<Free> getFreeList(int page){
		return freeDao.getList(page);
	}

	public Free getFree(String id) {
		return freeDao.getFree(id);
	}

	public Free getFreePrev(String id) {
		return freeDao.getFreePrev(id);
	}

	public Free getFreeNext(String id) {
		return freeDao.getFreeNext(id);
	}

	public List<Info> getInfoList(int page) {
		
		return infoDao.getList(page);
	}
	
	public Info getInfo(String id) {
		
		return infoDao.getInfo(id);
		
	}

	public Info getInfoPrev(String id) {
	
		return infoDao.getInfoPrev(id);
	}

	public Info getInfoNext(String id) {
		
		return infoDao.getInfoNext(id);
	}

	public int infoUpdate(String id, Info info) {
		
		infoDao.update(id,info);
		return 0;
	}

	public int infoInsert(Info info) {
		infoDao.insert(info);
		return 0;
	}


}
