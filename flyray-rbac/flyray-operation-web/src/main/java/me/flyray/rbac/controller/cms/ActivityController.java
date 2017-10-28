package me.flyray.rbac.controller.cms;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.flyray.rbac.annotation.SysLog;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/activity")
public class ActivityController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	/**
	 * 活动列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:activity:list")
	public R list(@RequestParam Map<String, Object> params){
		logger.info("查询团队类别列表请求参数:{}",params);
		Parameter parameter = new Parameter("activityService", "query");
		parameter.setMap(getCommonQueryParam());
		parameter.setMap(params);
		List<?> list = apiProvider.execute(parameter).getList();
		int total = list.size();
		logger.info("团队类别列表查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(list, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 添加团队类别
	 */
	@SysLog("保存团队类别")
	@RequestMapping("/save")
	@RequiresPermissions("cms:activity:save")
	public R save(@RequestParam Map<String, Object> params){
		logger.info("添加团队类别---请求参数：{}",params);
		MultipartFile files = (MultipartFile) params.get("img");
		return R.ok();
		
	}
	/**
	 * 修改团队类别
	 */
	@SysLog("修改团队类别")
	@RequestMapping("/update")
	@RequiresPermissions("cms:activity:update")
	public R update(@RequestBody Map<String, Object> params){
		
		logger.info("修改团队类别---请求参数{}",params);
		
		return R.ok();
	}
	
	/**
	 * 删除团队类别
	 */
	@SysLog("删除团队类别")
	@RequestMapping("/delete")
	@RequiresPermissions("cms:activity:delete")
	public R delete(@RequestBody Map<String, Object> params){
		
		logger.info("删除团队类别---请求参数{}",params);
		
		return R.ok();
	}
}
