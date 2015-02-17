package com.otis.marketing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otis.marketing.dao.AppVersionDao;
import com.otis.marketing.entity.AppVersion;
import com.otis.marketing.service.AppVersionService;
import com.otis.marketing.utils.CalendarUtils;
import com.otis.marketing.utils.Utils;
import com.otis.marketing.web.dto.AppVersionBean;

@Service("appVersionService")
@Transactional
public class AppVersionServiceImpl implements AppVersionService{

	private AppVersionDao appVersionDao;
	
	@Override
	public void addNewVersion(AppVersionBean version) {
		AppVersion appVersion = new AppVersion();
		if(version.getComment() != null) {
			appVersion.setComment(version.getComment());
		}
		if(version.getDownLoadLink() != null) {
			appVersion.setDownloadLink(version.getDownLoadLink());
		}
		if(version.getFileName() != null) {
			appVersion.setFileName(version.getFileName());
		}
		if(version.getFilePath() != null) {
			appVersion.setFilePath(version.getFilePath());
		}
		if(version.getVersionId() != null) {
			appVersion.setVersionId(version.getVersionId());
		}
		if(version.getVersionName() != null) {
			appVersion.setVersionName(version.getVersionName());
		}
		
		appVersion.setStatus(0);
		appVersion.setCreateTime(CalendarUtils.currentTime());
		appVersion.setUpdateTime(CalendarUtils.currentTime());
		
		appVersionDao.saveAppVersion(appVersion);
		
	}

	@Override
	public List<AppVersionBean> getAllVersions() {
		List<AppVersion> appVersions = appVersionDao.findAllAppVersion();
		List<AppVersionBean> versions = new ArrayList<AppVersionBean>();
		for(AppVersion version : appVersions) {
			AppVersionBean versionBean = new AppVersionBean();
			versionBean.setId(version.getId());
			versionBean.setVersionName(version.getVersionName());
			versionBean.setCreateTime(Utils.formateDate(version.getCreateTime()));
			versionBean.setUpdateTime(Utils.formateDate(version.getUpdateTime()));
			versionBean.setDownLoadLink(version.getDownloadLink());
			versionBean.setStatus(version.getStatus().toString());
			versions.add(versionBean);
		}
		
		return versions;
	}

	@Override
	public AppVersion getAppVersionById(Integer versionId) {
		return appVersionDao.findAppVersionById(versionId);
	}

	@Override
	public void updateAppVersion(AppVersionBean version) {
		AppVersion appVersion = appVersionDao.findAppVersionById(version.getId());
		
		if(version.getDownLoadLink() != null) {
			appVersion.setDownloadLink(version.getDownLoadLink());
		}
		
		if(version.getVersionName() != null) {
			appVersion.setVersionName(version.getVersionName());
		}
		appVersion.setUpdateTime(CalendarUtils.currentTime());
		
		appVersionDao.updateAppVersion(appVersion);
	}

	@Override
	public void deleteAppVersion(Integer versionId) {
		AppVersion appVersion = appVersionDao.findAppVersionById(versionId);
		appVersionDao.deleteAppVersion(appVersion);
	}
	
	@Autowired
	public void setAppVersionDao(AppVersionDao appVersionDao) {
		this.appVersionDao = appVersionDao;
	}

}
