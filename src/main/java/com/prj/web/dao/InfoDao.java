package com.prj.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.web.entity.Info;

public interface InfoDao {

	List<Info> getList(@Param("page") int page);

	Info getInfo(String id);

	Info getInfoPrev(String id);

	Info getInfoNext(String id);

	int update(String id, Info info);

	int insert(Info info);

	String getNextId();

}
