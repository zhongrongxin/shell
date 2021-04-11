package me.zrxjava.system.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.zrxjava.system.modules.ums.entity.UserRole;
import me.zrxjava.system.modules.ums.mapper.UserRoleMapper;
import me.zrxjava.system.modules.ums.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联 服务实现类
 * </p>
 *
 * @author void
 * @since 2020-09-17
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
