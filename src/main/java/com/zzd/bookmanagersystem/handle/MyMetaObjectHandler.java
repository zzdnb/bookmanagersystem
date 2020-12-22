package com.zzd.bookmanagersystem.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
@Slf4j
@Component
/**
 * 一定不要忘记把处理器加入到ioc容器中
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
	//	插入时候的填充策略
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("start insert fill...");
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}

	//更新时的填充策略
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("start update fill....");
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}


}
