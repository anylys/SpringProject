package com.anyly.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author lishengrong
 */
public class BeanCopyUtil {

	private final static Logger logger = LoggerFactory.getLogger(BeanCopyUtil.class);

	/**
	 *
	 * @param <E>
	 * @param srcList
	 *            源List
	 * @param targetClass
	 *            目标List的Class
	 * @return 包装了targetClass类型的List
	 */
	public static <S, T> List<T> listCopy(List<S> srcList, Class<T> targetClass) {
		if (CollectionUtils.isEmpty(srcList)) {
			return Collections.emptyList();
		}
		List<T> list = new ArrayList<>(srcList.size());
		for (S srcObj : srcList) {
			list.add(beanCopy(srcObj, targetClass));
		}
		return list;
	}

	/**
	 *
	 * @param src
	 *            源对象
	 * @param targetClass
	 *            目标对象的类型
	 * @return
	 * @return 目标对象
	 */
	public static <T> T beanCopy(Object src, Class<T> targetClass) {
		T targetObj = null;
		try {
			targetObj = targetClass.newInstance();
			BeanUtils.copyProperties(src, targetObj);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | BeansException e) {
			logger.error("BeanCopyUtil error {}", e);
		} catch (Exception e) {
			logger.error("BeanCopyUtil error {}", e);
		} 
		return targetObj;
	}

	/**
	 * create by lishengrong
	 * 
	 * @param src
	 *            源对象
	 * @param targetObj
	 *            目标对象
	 * @return 目标对象
	 */
	public static <T> T  beanCopyObject(Object src, T targetObj) {
		try {
			BeanUtils.copyProperties(src, targetObj);
		} catch (BeansException e) {
			logger.error("BeanCopyUtil error {}", e);
		}
		return targetObj;
	}
}
