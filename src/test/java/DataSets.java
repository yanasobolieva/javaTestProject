import org.testng.annotations.DataProvider;

    public class DataSets {

        @DataProvider(name = "SuccessLoginDataProvider")
        public Object[][] successLoginData() {
            return new Object[][]
                    {
                            {"testemail@mail.com","rahulshettyacademy",true,true},
                            {"testemail@mail.com","rahulshettyacademy",false,true},
                            {"testemail@mail.com","rahulshettyacademy",true,false}, //not good behavior
                            {"testemail@mail.com","rahulshettyacademy",false,false}, //not good behavior
                            {"","rahulshettyacademy",false,false} //not good behavior
                    };
        };

        @DataProvider(name = "ErrorLoginDataProvider")
        public Object[][] errorLoginData() {
            return new Object[][]
                    {
                            {"testemail@mail.com","",true,true},
                            {"testemail@mail.com","rahulshettyacadem",true,true},
                            {"","",true,true},
                            {"","",false,false}
                    };
        };

        @DataProvider(name = "SuccessPasswordReset")
        public Object[][] successPasswordReset() {
            return new Object[][]
                    {
                            {"User","testemail@mail.com","+3876665544"},
                    };
        }

}
