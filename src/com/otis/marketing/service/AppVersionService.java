package com.otis.marketing.service;

import java.util.List;

import com.otis.marketing.entity.AppVersion;
import com.otis.marketing.web.dto.AppVersionBean;

public interface AppVersionService {
	
	public void addNews(AppVersionBean version);
	
	public List<AppVersionBean> getAllVersions();
	
	public AppVersion getAppVersionById(Integer versionId);
	
	public void updateAppVersion(AppVersionBean version);
	
	public void deleteAppVersion(Integer versionId);
}
