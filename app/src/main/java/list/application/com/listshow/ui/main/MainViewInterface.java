package list.application.com.listshow.ui.main;


import list.application.com.listshow.models.Response;

/**
 * Created by Puspak on 30/07/18.
 */

public interface MainViewInterface {

    void showToast(String s);
    void hideProgressBar();
    void displayItems(Response movieResponse);
    void displayError(String s);
}
