package goodbye996.lambda.cases;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CaseThree {
    class Role{
        /**
         * 权限列表
         */
        private List<Permission> permissions;

        public List<Permission> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<Permission> permissions) {
            this.permissions = permissions;
        }

        public Role(List<Permission> permissions) {
            this.permissions = permissions;
        }

        public Role(){

        }
    }

    class Permission{
        /**
         * 权限名称
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Permission(String name) {
            this.name = name;
        }
    }

    List<Role> roleList;

    @Before
    public void init(){
        roleList = new ArrayList<>();
        Role adminRole = new Role();
        List<Permission> adminPermissionList = new ArrayList<>();
        adminPermissionList.add(new Permission("删除"));
        adminPermissionList.add(new Permission("查看"));
        adminPermissionList.add(new Permission("导出"));

        adminRole.setPermissions(adminPermissionList);

        Role userRole = new Role();
        List<Permission> userPermissionList = new ArrayList<>();
        userPermissionList.add(new Permission("新建"));
        userPermissionList.add(new Permission("修改"));
        userPermissionList.add(new Permission("删除"));
        userPermissionList.add(new Permission("查看"));

        userRole.setPermissions(userPermissionList);

        roleList.add(adminRole);
        roleList.add(userRole);
    }

    @Test
    public void test(){
        roleList.stream()
                //TODO: flatMap 扁平化map;获取对象中的集合类属性，组成一个新的流
                .flatMap(role->role.getPermissions().stream())
                .distinct()
                .forEach(role-> System.out.println(JSON.toJSONString(role,true)));
//                .collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(list,true));
    }
}
