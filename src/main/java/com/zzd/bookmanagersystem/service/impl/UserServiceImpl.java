package com.zzd.bookmanagersystem.service.impl;

import com.zzd.bookmanagersystem.entity.User;
import com.zzd.bookmanagersystem.mapper.UserMapper;
import com.zzd.bookmanagersystem.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-12-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
