import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author Austin Wang
 * @date 2021/3/23 - 15:58
 */
public class RoleTest {

    //  使用 checkRole 来检验角色时,若权限不足会返回 false
    @Test
    public void testHasRole() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro_role.ini");
        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // 得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("acey", "123456");
        currentUser.login(token);
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
        System.out.println(currentUser.hasRole("role1") ? "has role1" : "has not role1");
        System.out.println(currentUser.hasRole("role2") ? "has role2" : "has not role2");
        currentUser.logout();
    }

    @Test
    public void testCheckRole() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro_role.ini");
        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // 得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("acey", "123456");
        currentUser.login(token);
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
        currentUser.checkRole("role2");

        currentUser.logout();
    }
}

    //  使用 checkRole 来检验角色时,若权限不足会抛出异常
