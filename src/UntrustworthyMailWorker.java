public  class UntrustworthyMailWorker implements MailService {
    private  RealMailService realMailService = new RealMailService();
    private  MailService[] mailServices;
    public UntrustworthyMailWorker(MailService[] services){
        mailServices = services;
    }

    public RealMailService getRealMailService(){
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable processed = mail;
        for (MailService mails : mailServices) {
            processed = mails.processMail(processed);
        }
        return realMailService.processMail(processed);
    }
}