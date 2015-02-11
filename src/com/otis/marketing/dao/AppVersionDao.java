package com.otis.marketing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otis.marketing.entity.AppVersion;


public interface AppVersionDao {

	public void saveAppVersion(AppVersion appVersion) throws DataAccessException;
	
	public void updateAppVersion(AppVersion appVersion) throws DataAccessException;
	
	public void deleteAppVersion(AppVersion appVersion) throws DataAccessException;
	
	public List<AppVersion> findAllAppVersion() throws DataAccessException;
	
	public AppVersion findAppVersionById(Integer versionId) throws DataAccessException;
	
}
