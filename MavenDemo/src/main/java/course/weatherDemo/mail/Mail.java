package course.weatherDemo.mail;

import com.sun.security.sasl.Provider;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

public class Mail {
    public void sendEmail(String from,String to,String text,String subject) throws MessagingException {
        //设置SSL连接邮箱环境
        Security.addProvider(new Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        //配置邮箱信息
        Properties props = System.getProperties();
        //邮件服务器
        props.setProperty("mail.smtp.host","smtp.qq.com");
        props.setProperty("mail.smtp.socketFactory.class",SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback","false");
        //邮箱服务器端口
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        //鉴权信息
        props.setProperty("mail.smtp.auth","true");
        //建立临时会话
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            //身份认证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //1.账户 授权码
                return new PasswordAuthentication("411559669","krtvnrxtzqtbcada");
            }
        });
        //建立邮件对象
        MimeMessage message = new MimeMessage(session);
        //设置邮件的发件人
        try {
            message.setFrom(new InternetAddress(from+"@qq.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //2.设置邮件的收件人
        message.setRecipients(Message.RecipientType.TO, to+"@qq.com");
        //设置邮件的主题
        message.setSubject(subject);
        //文本部分
        message.setContent(text, "text/html;charset=UTF-8");
        message.saveChanges();
        //发送邮件
        Transport.send(message);

    }

}
