import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author Austin Wang
 * @date 2021/3/23 - 17:11
 */
public class PermissionTest {

    //  使用 checkPermission 来检验权限时,若权限不足会返回 false
    @Test
    public void testIsPermitted() {
        Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini","acey","123456");
        System.out.println(currentUser.isPermitted("user:select") ? "has user:select" : "has not user:select");

        currentUser.logout();
    }
    @Test
    public void testCheckPermitted() {
        Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "acey", "123456");
        // Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");
        currentUser.checkPermission("user:select");
        currentUser.logout();
    }
}