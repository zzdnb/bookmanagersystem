package com.zzd.bookmanagersystem.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("书籍实体")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 书籍名称
	 */
	@ApiModelProperty("书籍名称")
	private String name;
	/**
	 * 书籍名称
	 */
	@ApiModelProperty("书籍类型ID")
	private int cid;
	/**
	 * 书籍价格
	 */
	@ApiModelProperty("书籍价格")
	private String price;

	/**
	 * 书籍封面
	 */
	@ApiModelProperty("书籍封面")
	private String cover;

	/**
	 * 创建时间
	 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty("书籍加入时间")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 更新时间
	 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty("书籍更新时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
    /**
     * 书籍介绍
     */
    @ApiModelProperty("书籍介绍")
    private String description;

}
