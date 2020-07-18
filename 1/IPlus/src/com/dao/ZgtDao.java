package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zgt;

public interface ZgtDao {
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<Zgt> show(Map<String,Object> map); 
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 删除主观题
	 * @param zgtno
	 */
	public void delZgt(int zgtno);
	/**
	 * 添加主观题
	 * @param z
	 */
	public void addZgt(Zgt z);
	/**
	 * 查找主观题
	 * @param zgtno
	 * @return
	 */
	public Zgt findByZgtno(int zgtno); 
	/**
	 * 修改主观题
	 * @param z
	 */
	public void updateZgt(Zgt z);
	/**
	 * 查找主观题
	 * @param zgtnr
	 * @return
	 */
	public List<Zgt> findZgt(String zgtnr);
	/**
	 * 遍历题库
	 * @return
	 */
	public List<Zgt> start(int suid);
}
