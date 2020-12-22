package com.zzd.bookmanagersystem.common.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {


	private Long id;

	/**
	 * 书籍名称
	 */
	@ApiModelProperty("书籍名称")
	private String name;

	/**
	 * 书籍价格
	 */
	@ApiModelProperty("书籍价格")
	private String price;
	/**
	 * 书籍介绍
	 */
	@ApiModelProperty("书籍介绍")
	private String description;
	/**
	 * 书籍名称
	 */
	@ApiModelProperty("书籍类型ID")
	private int cid;
}
