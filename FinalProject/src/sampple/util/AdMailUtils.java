package sampple.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class AdMailUtils {
	
	public static void executeMethod(String[] args) throws AddressException, MessagingException, GeneralSecurityException, UnsupportedEncodingException{
    	//取得所有用戶email
    	String[] userMails = getRecipients();
    	
    	//ArrayList<String> userMails = new ArrayList<String>();//存放所有用戶的email
    	//for(Users u:list) {
    	//	userMails.add(u.getEmail());
    	//}
    	
    	String host = "smtp.gmail.com";
    	int port=587; //Gmail的端口號
    	final String sendName = "w92532@gmail.com";
    	final String sendPassword = "Ww414200";//your password
    	//建立一個屬性物件
        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");//SMTP服務使用者認證
        props.put("mail.smtp.starttls.enable", "true");// 根據郵件服務器是否需要ttl驗證添加 
        //設定mail Server
        props.put("mail.smtp.host", host);//設定SMTP伺服器地址
        props.put("mail.smtp.port", port);//設定SMTP埠號
        props.put("mail.debug", "true");
       

        //創建程序到郵件服務器的第一次對話
        Session session = Session.getInstance(props, new Authenticator() {
        	   protected PasswordAuthentication getPasswordAuthentication() {
        	    return new PasswordAuthentication(sendName, sendPassword);
        	  }
        });
        //控制檯輸出debug信息
        session.setDebug(true);
               
        //創建一個Message，它相當於郵件內容
        //相當於獲取信封
        for(String email:userMails) {
        	try {
        		Message message = new MimeMessage(session);
        	
        		//設置發送人
        		message.setFrom(new InternetAddress("w92532@gmail.com"));
        		//設置發送方式與接收者
        		message.setRecipient(RecipientType.TO, new InternetAddress(email));
        		//郵件主題
        		message.setSubject("台灣sampple網廣告信~");
        		//郵件內容
        		//String emailMsg = buildMsg(subject,userName,url);
        		message.setContent("emailMsg_test", "text/html;charset=utf-8");

            
        		//創建 Transport用來發送郵件
        		Transport.send(message);
            
        	}catch(MessagingException e) {
        		throw new RuntimeException(e);
        	}
        }
        
    }
    
    //創建郵件內容
    public static String buildMsg(String subject, String userName, String url) {
		// 123@gmail.com > 123
		userName = userName.substring(0, userName.indexOf('@'));
		
		return "<html><head><title>" + subject +"</title></head>"
			+ "<body> 親愛的 " + userName + " 您好,</br>"
			+ "請點擊以下連結進行" + subject + "作業</br>"
			+ url
			+ "</body></html>";
	}
    
    //獲取所有收件人方式
    public static String[] getRecipients() {
        File recipientsFile = new File("C:/DataSource/FinalProject/FinalProject/WebContent/email.txt");
        InputStream in = null;
        BufferedReader br = null;
        try {
            in = new FileInputStream(recipientsFile);
            br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuilder builder = new StringBuilder();
            // 讀入
            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append(",");
            }
            // 分組傳回
            return builder.toString().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}

