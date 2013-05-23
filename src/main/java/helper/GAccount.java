package helper;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

/**
 * Created by francesco on 22/05/13.
 */
public class GAccount {

        private AccountManager accountManager;
        private String username = null;

        public GAccount(Context appContext){
                accountManager = (AccountManager) appContext.getSystemService(Context.ACCOUNT_SERVICE);
                Account[] accounts = accountManager.getAccounts();
                this.setUserFromGoogle(accounts);

        }

        private void setUserFromGoogle(Account[] accounts){

                for(Account account: accounts)
                {
                        if(account.type.equalsIgnoreCase("com.google"))
                        {
                                this.username = account.name;
                                break;
                        }
                }
        }


        public String getUsername() {
                return username;
        }
}
