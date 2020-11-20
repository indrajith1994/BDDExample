package APIUtil;

public class xpathlink {
    public static String petstoresignin="//a[contains(text(),'Sign In')]";
    public static String petstoreregister="//a[contains(text(),'Register Now')]";
    public static String petstore_userinfopage="//h3[contains(text(),'User Information')]";
    public static String petstore_reg_fname="//input[@name='account.firstName']";
    public static String petstore_reg_lname="//input[@name='account.lastName']";
    public static String petstore_reg_email="//input[@name='account.email']";
    public static String petstore_reg_phone="//input[@name='account.phone']";
    public static String petstore_reg_addr="//input[@name='account.address1']";
    public static String petstore_reg_city="//input[@name='account.city']";
    public static String petstore_reg_state="//input[@name='account.state']";
    public static String petstore_reg_zip="//input[@name='account.zip']";
    public static String petstore_reg_country="//input[@name='account.country']";
    public static String petstore_reg_uid="//input[@name='username']";
    public static String petstore_reg_pwd="//input[@name='password']";
    public static String petstore_reg_reppwd="//input[@name='repeatedPassword']";
    public static String petstore_reg_mylist="//input[@name='account.listOption']";
    public static String petstore_reg_mybanner="//input[@name='account.bannerOption']";
    public static String petstore_reg_btn="//input[@name='newAccount']";
    public static String petstoresignon="//input[@name='signon']";
    public static String petstore_signout="//a[contains(text(),'Sign Out')]";
    public static String petstore_myacc="//a[contains(text(),'My Account')]";
    public static String petstore_fish="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=FISH']";
    public static String petstore_dogs="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=DOGS']";
    public static String petstore_reptiles="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=REPTILES']";
    public static String petstore_cats="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=CATS']";
    public static String petstore_birds="//div[@id='QuickLinks']/a[@href='/actions/Catalog.action?viewCategory=&categoryId=BIRDS']";
    public static String addToCart="//a[contains(text(),'Add to Cart')]";
    public static String updateCart="//input[@name='updateCartQuantities']";
    public static String proceedCheckout="//a[contains(text(),'Proceed to Checkout')]";
    public static String continuepayment="//input[@name='newOrder']";
    public static String confirmCheckout="//a[contains(text(),'Confirm')]";
    public static String orderConfirmation="//li[contains(text(),'Thank you, your order has been submitted')]";
    public static String Price="//a[contains(text(),'EST-4')]/../../td[6]";

}
