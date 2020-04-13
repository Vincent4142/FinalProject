package sampple.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	//String email:用戶用來激活的郵箱
    //String emailMsg:郵件內容
    public static void sendMail(String email, String password,String status) throws AddressException, MessagingException, GeneralSecurityException, UnsupportedEncodingException{
    	
    	String host = "smtp.gmail.com";
    	int port=587;
    	final String sendName = "w92532@gmail.com";
    	final String sendPassword = "Ww414200";//your password

        Properties props = new Properties();
        
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //設定mail Server
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.debug", "true");
       

        //創建程序到郵件服務器的第一次對話
        Session session = Session.getInstance(props, new Authenticator() {
        	   protected PasswordAuthentication getPasswordAuthentication() {
        	    return new PasswordAuthentication(sendName, sendPassword);
        	  }
        });
        //控制檯輸出debug信息
        session.setDebug(true);
        
        //判斷使用者是進行註冊激活或忘記密碼操作
        
        
        String emailMsg = "註冊成功，請點擊<a href='http://localhost:8080/FinalProject/signup.action?email="
				+ email + "&password="+password+"  '>按此激活</a>" ;
        
        //創建一個Message，它相當於郵件內容
        //相當於獲取信封
        try {
        	Message message = new MimeMessage(session);
        	
            //設置發送人
            message.setFrom(new InternetAddress("w92532@gmail.com"));
            //設置發送方式與接收者
            message.setRecipient(RecipientType.TO, new InternetAddress(email));
            //郵件主題
            message.setSubject("sampple註冊驗證信~");
            //郵件內容
            message.setContent(emailMsg, "text/html;charset=utf-8");

            
            //創建 Transport用來發送郵件
            Transport.send(message);
            
        }catch(MessagingException e) {
        	 throw new RuntimeException(e);
        }
        
    }
}

