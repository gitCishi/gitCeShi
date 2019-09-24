package cn.appsys.service.backend;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppServiceImpl implements AppService {
	@Resource
	private AppInfoMapper mapper;
	
	@Override
	public AppInfo getAppInfo(Integer id) {
		return mapper.getAppInfo(id, null);
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
									Integer queryCategoryLevel1,
									Integer queryCategoryLevel2, Integer queryCategoryLevel3,
									Integer queryFlatformId,Integer currentPageNo,
									Integer pageSize) {
		return mapper.getAppInfoList(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, 
				                 queryCategoryLevel3, queryFlatformId, null, (currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName,
							Integer queryCategoryLevel1, 
							Integer queryCategoryLevel2,
							Integer queryCategoryLevel3, 
							Integer queryFlatformId) {
		return mapper.getAppInfoCount(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2, 
									queryCategoryLevel3, queryFlatformId, null);
	}

	@Override
	public boolean updateSatus(Integer status, Integer id) {
		boolean flag = false;
		if(mapper.updateSatus(status, id) > 0 ){
			flag = true;
		}
		return flag;
	}
}
