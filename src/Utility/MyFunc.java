package Utility;

public class MyFunc {
    public static void Wait(int sn){

        try {
            Thread.sleep(sn* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    //çoğu yerde aynı mesaj doğrulaması kullanıldıgı için bu bolumu ortak fonksiyonların yer aldıgı MyFuct a taşıdık
  //  public static void successMessageValidation (){

    //    WebElement msgLabel= BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
   //     Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
   // }



}
