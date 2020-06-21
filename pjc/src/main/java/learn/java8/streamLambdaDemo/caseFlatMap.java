package learn.java8.streamLambdaDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Role {
    /**
     * 权限列表
     */
    private List<Permission> permissions;
}

/**
 * 权限
 */
@Data
@AllArgsConstructor
class Permission {
    /**
     * 权限名称
     */
    private String name;
}

/**
 * 扁平化
 */
public class caseFlatMap {

    /**
     * 用户角色列表
     */
    List<Role> roleList;

    @Before
    public void init() {
        roleList = new ArrayList();

        Role adminRole = new Role();
        List<Permission> adminPermissionList = Arrays.asList(
                new Permission("删除"),
                new Permission("查看"),
                new Permission("导出"));
        adminRole.setPermissions(adminPermissionList);

        Role userRole = new Role();
        List<Permission> userPermissionList = Arrays.asList(
                new Permission("新建"),
                new Permission("修改"),
                new Permission("删除"),
                new Permission("查看"));
        userRole.setPermissions(userPermissionList);

        roleList.add(adminRole);
        roleList.add(userRole);
    }

    @Test
    /**
     * 集合中所有的权限
     */
    public void testFlatMap() {
        roleList.stream()
                // TODO 扁平化Map 获取map中的集合属性组成一个新的流
                .flatMap(role -> role.getPermissions().stream())
                .distinct()
                .forEach(PrintStreamUtil::printObject);
    }

}
