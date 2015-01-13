package com.otis.marketing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.Resources;

public interface ResourceDao {

	public List<Resources> findAll() throws DataAccessException;
}
