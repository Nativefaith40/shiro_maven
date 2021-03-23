import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author Austin Wang
 * @date 2021/3/23 - 17:15
 */
public class ShiroUtil {

    public static Subject login(String classpath,String name,String password){
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        //2.设置用户的权限信息到安全管理器
        Realm realm=new IniRealm(classpath);
        securityManager.setRealm(realm);
        //3.使用SecurityUtils将securityManager设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //4.创建一个Subject实例，该实例认证要使用上面创建的securityManager进行
        Subject subject=SecurityUtils.getSubject();
        //5.创建token令牌，记录用户认证的身份和凭证即证号和密码
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        //6.主体要进行登录，登录的时候进行认证的检查
        subject.login(token);
        System.out.println("用户认证状态："+subject.isAuthenticated());
        return subject;
    }
}