package com.zzd.bookmanagersystem.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 *
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID/管理员ID
	 */
	@TableId(value = "uid", type = IdType.AUTO)
	private Integer uid;

	/**
	 * 用户昵称
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户真实姓名
	 */
	private String name;

	/**
	 * 用户生日
	 */
	private String birthday;

	/**
	 * 用户权限 0为管理员，1为用户
	 */
	private Integer authority;

	/**
	 * 电话
	 */
	private String telephone;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;


}
