package com.prj.web.dao.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.prj.web.dao.InfoDao;
import com.prj.web.entity.Info;

public class SpringInfoDao implements InfoDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Info> getList(int page) {
		
		String sql="select * from soonface2db.Info order by hit DESC limit ?,10 ";
		List<Info> list = template.query(sql, new Object[] {(page-1)*10}, BeanPropertyRowMapper.newInstance(Info.class));
		return list;
	}

	@Override
	public Info getInfo(String id) {
		String sql = "select * from soonface2db.Info where id=?";
		Info info = template.queryForObject(sql, new Object[] {id}, BeanPropertyRowMapper.newInstance(Info.class));
		return info;
	}

	@Override
	public Info getInfoPrev(String id) {
		
		String sql="select * from soonface2db.Info where id < CAST(? as UNSIGNED) order by hit DESC limit 1";
		Info prev = template.queryForObject(sql, new Object[] {id}, BeanPropertyRowMapper.newInstance(Info.class));
		return prev;
	}

	@Override
	public Info getInfoNext(String id) {
		String sql="select * from soonface2db.Info where id > CAST(? as UNSIGNED) order by hit ASC limit 1";
		Info next = template.queryForObject(sql, new Object[] {id}, BeanPropertyRowMapper.newInstance(Info.class));
		return next;
	}

	@Override
	public int update(String id, Info info) {
		String sql ="UPDATE soonface2db.Info SET title=?,content=? WHERE id=?";
		
		int result=template.update(sql
				,info.getTitle()
				,info.getContent()
				,id);
		return result;
	}

	@Override
	public int insert(Info info) {
		String sql = "insert into soonface2db.Info(id, title, content, writerId) values(?, ?, ?, ?)";
		
		int result = 0;
		result += template.update(sql
				,getNextId()
				,info.getTitle()
				,info.getContent()
				,info.getWriterId() );
	
		
		return 0;
	}
	
	@Override
	public String getNextId() {
		String sql="select ifnull(MAX(CAST(id as unsigned)),0)+1 from soonface2db.Info";
		
		String result = template.queryForObject(
					sql, 
					String.class);

		return result;
	}

}
