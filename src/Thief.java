public  class Thief implements MailService {
    private int minPrice = 0;
    private int stolenPrice = 0;
    public Thief(int minPrice){
        this.minPrice = minPrice;
    }

    public int getStolenValue(){
        return stolenPrice;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        if(mail.getClass() == MailPackage.class) {
            Package pac = ((MailPackage)mail).getContent();
            if(pac.getPrice() >= minPrice){
                stolenPrice += pac.getPrice();
                mail = new MailPackage(mail.getFrom(), mail.getTo(),new Package("stones instead of " + pac.getContent(), 0));
            }
        }
        return mail;
    }
}