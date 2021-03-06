package me.zrxjava.system.modules.ems.vo;

import com.diboot.core.binding.annotation.BindField;
import com.diboot.core.binding.annotation.BindFieldList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zrxjava.system.modules.ems.entity.Dept;
import me.zrxjava.system.modules.ems.entity.Role;
import me.zrxjava.system.modules.ems.entity.User;

import java.util.List;

/**
 * @author void
 * @create 2020-10-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVo extends User {

    @BindField(entity=Dept.class, field="name", condition="dept_id=dept_id")
    private String deptName;

//    @BindEntityList(entity = Role.class, condition = "role_id=role_id")
//    private List<Role> roles;

    @BindFieldList(entity = Role.class, field="name", condition="this.user_id = sys_users_roles.user_id and role_id = sys_users_roles.role_id")
    private List<String> roleNames;

//    @BindEntity(entity = Dept.class, condition="dept_id=dept_id")
//    private Dept dept;

}
