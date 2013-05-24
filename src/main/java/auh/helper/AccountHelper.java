package auh.helper;

import android.accounts.AccountManager;
import android.content.Context;

public class AccountHelper
{

        private AccountManager accountManager;
        private String Gname = null;
        private String FBname = null;

        public AccountHelper(Context appContext){
                accountManager = (AccountManager) appContext.getSystemService(Context.ACCOUNT_SERVICE);
                android.accounts.Account[] accounts = accountManager.getAccounts();
                this.setUser(accounts);

        }

        private void setUser(android.accounts.Account[] accounts){

                for(android.accounts.Account account: accounts)
                {
                        if(account.type.equalsIgnoreCase("com.google"))
                        {
                                this.Gname = account.name;
                                if(this.FBname!=null)
                                        break;
                        }

                        if(account.type.equalsIgnoreCase("com.facebook.auth.login")){
                                this.FBname = account.name;
                                if(this.Gname!=null)
                                        break;
                        }
                }
        }


        public String getGname() {
                return this.Gname;
        }

        public String getFBname() {
                return this.FBname;
        }


}
