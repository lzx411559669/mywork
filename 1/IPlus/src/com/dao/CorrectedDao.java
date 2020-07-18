package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Corrected;

public interface CorrectedDao {
	/**
	 * 显示所有批改后的试卷
	 * @param map
	 * @return
	 */
	public List<Corrected> show(Map<String,Object> map);
	/**
	 * 返回总记录数
	 * @return
	 */
	public int count();
	/**
	 * 自动导入批改后的试卷信息
	 * @param c
	 */
	public void add(Corrected c);
	/**
	 * 显示成绩
	 * @return
	 */
	public List<Corrected> showmark(int sid);
}
