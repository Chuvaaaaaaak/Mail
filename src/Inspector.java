import  java.util.logging.Level;
import java.util.logging.Logger;


public  class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if(mail.getClass() == MailPackage.class) {
            Package pac = ((MailPackage)mail).getContent();
            String content = pac.getContent();
            if(content.indexOf("stones instead of ") == 0) {
                throw new StolenPackageException();
            } else if(content.contains(Main.WEAPONS) || content.contains(Main.BANNED_SUBSTANCE)){
                throw new IllegalPackageException();
            }
        }
        return mail;
    }
}