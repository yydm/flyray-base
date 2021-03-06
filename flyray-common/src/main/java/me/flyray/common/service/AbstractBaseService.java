package me.flyray.common.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import me.flyray.common.dao.BaseDao;
import me.flyray.common.utils.BeanUtils;

/** 
* @author: bolei
* @date：2017年4月16日 下午9:29:30 
* @description：service公共类
*/

public abstract class AbstractBaseService<T> implements BaseService{
	
	@Autowired
	private BaseDao<T> baseDao;
	protected Class<T> clazz;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<T> ts= baseDao.queryList(map);
			for (T t : ts) {
				Map<String, Object> resultMap = BeanUtils.objectToMap(t);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return baseDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtils.mapToObject(map, clazz);
			baseDao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtils.mapToObject(map, clazz);
			baseDao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBatch(List<Long> ids) {
		if(ids == null){
			return;
		}
		try {
			baseDao.deleteBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> queryObject(Map<String, Object> map) {
		
		if (map == null)     
            return null;
		Map<String, Object> resultMap = null;
		try {
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
			@SuppressWarnings("unchecked")
			T t = (T)BeanUtils.mapToObject(map, clazz);
			resultMap = BeanUtils.objectToMap(baseDao.queryObject(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
	@Override
	public Map<String, Object> queryById(Long id) {
		Map<String, Object> resultMap = null;
		try {
			resultMap = BeanUtils.objectToMap(baseDao.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		};
		return resultMap;
	}
	
}
