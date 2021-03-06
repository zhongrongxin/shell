package me.zrxjava.system.modules.ems.service.impl;

import me.zrxjava.system.modules.ems.entity.Menu;
import me.zrxjava.system.modules.ems.mapper.MenuMapper;
import me.zrxjava.system.modules.ems.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author void
 * @since 2020-09-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getByRoleId(Long roleId) {
        return menuMapper.getByRoleId(roleId);
    }
}
