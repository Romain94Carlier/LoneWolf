package main.java.controller;

/*
 * ctrl.java
 * Created by Murad R. Imanbayli <muradimanbayli at gmail.com> on Sep 24, 2016  3:46:59 PM
 * Copyright www.imanbayli.net 2016.All rights reserved
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import main.java.service.Game;

/**
 *
 * @author Murad R. Imanbayli <muradimanbayli at gmail.com>
 */
@ManagedBean
public class PopupController implements Serializable{
    
    private boolean showPopup;
    
    public void show(){
        showPopup=true;
    }
    public void hide(){
        showPopup=false;
    }

    public boolean isShowPopup() {
//        return showPopup;
    	return Game.getInstance().fightIsOngoing();
    }

    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
        throw new IllegalAccessError();
    }
    
}
