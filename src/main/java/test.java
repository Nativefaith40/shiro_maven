import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author Austin Wang
 * @date 2021/3/23 - 15:08
 */
public class test {

    public static void main(String[] args) {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
//        创建 token 令牌,用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("acey", "123456");
        try {
//            身份验证
            currentUser.login(token);
            System.out.println("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }
    }
}