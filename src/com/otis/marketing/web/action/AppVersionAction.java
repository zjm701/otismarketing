package com.otis.marketing.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.otis.marketing.entity.AppVersion;
import com.otis.marketing.service.AppVersionService;
import com.otis.marketing.web.dto.AppVersionBean;

@Scope("request")
@Controller("appVersionAction")
public class AppVersionAction extends BaseAction {

	private static final long serialVersionUID = 7730925154551242656L;

	private static Logger logger = Logger.getLogger(AppVersionAction.class);
	
	private String versionName;
	
	private String downLoadLink;
	
	private Integer id;

	private List<AppVersionBean> data = new ArrayList<AppVersionBean>();

	@Autowired
	private AppVersionService appVersionService;

	public String getVersionsInfoList() {
		List<AppVersionBean> versionList = appVersionService.getAllVersions();
		data.addAll(versionList);

		return "versionInfos";
	}
	
	public String addVersion() {
		AppVersionBean version = new AppVersionBean();
		version.setVersionName(versionName);
		version.setDownLoadLink(downLoadLink);

		appVersionService.addNewVersion(version);

		return SUCCESS;
	}

	public String previewVersion() {
		
		AppVersion appVersion = appVersionService.getAppVersionById(id);
		this.versionName = appVersion.getVersionName();
		this.downLoadLink = appVersion.getDownloadLink();
		
		return SUCCESS;
	}

	public String initUpdate() {
		AppVersion appVersion = appVersionService.getAppVersionById(id);
		this.versionName = appVersion.getVersionName();
		this.downLoadLink = appVersion.getDownloadLink();

		return SUCCESS;
	}
	
	public String updateVersion() {
		AppVersionBean version = new AppVersionBean();
		version.setId(id);
		version.setVersionName(versionName);
		version.setDownLoadLink(downLoadLink);

		appVersionService.updateAppVersion(version);
		
		return SUCCESS;
	}

	public String deleteVersion() {
		appVersionService.deleteAppVersion(id);
		
		return SUCCESS;
	}
	
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public List<AppVersionBean> getData() {
		return data;
	}

	public String getDownLoadLink() {
		return downLoadLink;
	}

	public void setDownLoadLink(String downLoadLink) {
		this.downLoadLink = downLoadLink;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
