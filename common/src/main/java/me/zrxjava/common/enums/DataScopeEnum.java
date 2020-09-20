package me.zrxjava.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据权限枚举
 * @author void
 * @create 2020-09-20
 */
@Getter
@AllArgsConstructor
public enum DataScopeEnum {

    /* 全部的数据权限 */
    ALL("全部", "全部的数据权限"),
    /* 自己部门的数据权限 */
    THIS_LEVEL("本级", "自己部门的数据权限"),
    /* 自己及子部门的数据权限 */
    INCLUDE_CHILD_LEVEL("本级及以下部门","自己及子部门的数据权限"),
    /* 本人数据权限 */
    SELF_LEVEL("仅本人","本人数据权限"),
    /* 自定义的数据权限 */
    CUSTOMIZE("自定义", "自定义的数据权限");

    private final String value;
    private final String description;

    public static DataScopeEnum find(String val) {
        for (DataScopeEnum dataScopeEnum : DataScopeEnum.values()) {
            if (val.equals(dataScopeEnum.getValue())) {
                return dataScopeEnum;
            }
        }
        return null;
    }

}
