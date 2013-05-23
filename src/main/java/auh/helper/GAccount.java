package auh.helper;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

/**
 * Created by francesco on 22/05/13.
 */
public class GAccount {

        private AccountManager accountManager;
        private String Gname = null;
        private String FBname = null;

        public GAccount(Context appContext){
                accountManager = (AccountManager) appContext.getSystemService(Context.ACCOUNT_SERVICE);
                Account[] accounts = accountManager.getAccounts();
                this.setUser(accounts);

        }

        private void setUser(Account[] accounts){

                for(Account account: accounts)
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
